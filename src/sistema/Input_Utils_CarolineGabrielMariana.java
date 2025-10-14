package sistema;

import java.util.Scanner;
import java.util.function.Function;

public class Input_Utils_CarolineGabrielMariana 
{
    private static <T> T lerGenerico(
        Scanner scanner,
        String mensagem,
        String mensagemErro,
        Function<String, T> parser
    )
    {
        while (true)
        {
            if (mensagem != null)
                System.out.print(mensagem);
            
                String input = scanner.nextLine();

            try 
            {
                return parser.apply(input);
            } 
            catch (Exception e)
            {
                System.err.println(mensagemErro);
            }
        }
    }

    public static int lerInt(Scanner scanner, String mensagem)
    {
        return lerGenerico(
                    scanner,
                    mensagem,
                    "\n[INPUT-ERROR]: Entrada inválida. Por favor, digite um número.\n",
                    Integer::parseInt);
    }

    public static String lerString(Scanner scanner, String mensagem, boolean deveTerUmaLetra)
    {
        return lerGenerico(
                    scanner,
                    mensagem,
                    "\n[INPUT-ERROR]: Entrada inválida. Por favor, digite uma palavra.\n",
                    entrada -> {
                        if (deveTerUmaLetra)
                        {
                            // Verifica se há pelo menos uma letra (maiúscula ou minúscula)
                            if (!entrada.matches(".*[a-zA-Z].*"))
                            {
                                throw new IllegalArgumentException();
                            }
                        }
                        return entrada;
                    }
                ); // Essa função retorna o próprio argumento.
    }

    public static double lerDouble(Scanner scanner, String mensagem)
    {
        return lerGenerico(
                    scanner,
                    mensagem,
                    "\n[INPUT-ERROR]: Entrada inválida. Por favor, digite um valor do tipo real.\n",
                    Double::parseDouble);
    }


    
}
