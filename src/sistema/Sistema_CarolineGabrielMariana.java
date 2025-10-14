package sistema;

import configuracoes.Serializador_CarolineGabrielMariana;

import imobiliaria.Imobiliaria_CarolineGabrielMariana;
import imoveis.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Sistema_CarolineGabrielMariana 
{
    private Imobiliaria_CarolineGabrielMariana imobiliaria;
    private Scanner scanner;

    
    
    public Sistema_CarolineGabrielMariana() 
    {
        this.imobiliaria = new Imobiliaria_CarolineGabrielMariana();
        this.scanner = new Scanner(System.in);
    }

    
    public void executar() 
    {
        int opcao;

        do 
        {
            System.out.println("\n--- Sistema Imobiliaria ---");
            System.out.println("1. Cadastrar Imóvel");
            System.out.println("2. Listar Imoveis");
            System.out.println("3. Remover Imóvel");
            System.out.println("4. Salvar Dados");
            System.out.println("0. Sair");
            
            opcao = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Escolha uma opção: ");


            switch (opcao) 
            {
                case 1:
                    cadastrarImovel();
                    salvarDados();
                    break;
                case 2:
                    listarImoveis();
                    break;
                case 3:
                    removerImovel();
                    break;
                case 4:
                    salvarDados();
                    break;
                case 0:
                    salvarDados();
                    System.out.println("\nSaindo do sistema...");
                    break;
                default:
                    System.out.println("\n[SISTEMA-ERROR]: Opção inválida!");
            }
        } while (opcao != 0);
    }


    private void cadastrarImovel() 
    {
        System.out.println("\n\nTipos de Imovel:");

        int tipo = Input_Utils_CarolineGabrielMariana.lerInt(scanner, 
                                                    "1. Casa Residencial\n2. Comercial\nEscolha o tipo: "
                                                            );
                                                           
        String codigo = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                            "Código do Imóvel: ",
                                                                    false
                                                                    );

        String endereco = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                              "Endereço do Imóvel: ",
                                                         true
                                                                      );

        Double area = Input_Utils_CarolineGabrielMariana.lerDouble(scanner,
                                                          "Área do Imóvel: "
                                                                  );

        int quartos = Input_Utils_CarolineGabrielMariana.lerInt(scanner,
                                                        "Número de Quartos: "
                                                               );

        double valor = Input_Utils_CarolineGabrielMariana.lerDouble(scanner, 
                                                           "Valor do Imóvel: "
                                                                   );

        if (tipo == 1) 
        {
            String garagem = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Tem garagem? (sim/nao) ", true);
            
            while (!garagem.equals("sim") && !garagem.equals("nao"))
            {
                System.err.println("[INPUT-ERROR]: Por favor, responda somente com sim ou nao.");

                garagem = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Tem garagem? (sim/nao) ", true);
            }
            
            String jardim = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Tem jardim? (sim/nao) ", true);
            
            while (!jardim.equals("sim") && !jardim.equals("nao"))
            {
                System.err.println("[INPUT-ERROR]: Por favor, responda somente com sim ou nao.");

                jardim = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Tem jardim? (sim/nao) ", true);
            }
            
            CasaResidencial_CarolineGabrielMariana casa = new CasaResidencial_CarolineGabrielMariana(
                codigo, endereco, area, quartos, valor, Boolean.parseBoolean(garagem), Boolean.parseBoolean(jardim));

            imobiliaria.getImoveis().add(casa);
        }
        
        else if (tipo == 2) 
        {
            String tipoComercial = Input_Utils_CarolineGabrielMariana.lerString(scanner, "\nTipo de Comércio: ", true);

            int salas = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Número de salas: ");
            
            Comercial_CarolineGabrielMariana comercial = new Comercial_CarolineGabrielMariana(codigo,
             endereco, area, quartos, valor, tipoComercial, salas);
            
            imobiliaria.getImoveis().add(comercial);
        }
        
        System.out.println("Imovel cadastrado com sucesso!");
    }
    
    

    private void listarImoveis() 
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = imobiliaria.getImoveis();
        
        if (imoveis.isEmpty()) 
        {
            System.out.println("\n[LISTAR-IMOVEIS]: Nao há imóveis cadastrados.");
            return;
        }   

        System.out.println("\n\n--- Lista de Imóveis ---");
        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
            System.out.println("\n" + imovel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void removerImovel()
    {
        String codigoImovel = Input_Utils_CarolineGabrielMariana.lerString(
            scanner, "\nDigite o código do Imóvel: ", false);
        
        Imovel_CarolineGabrielMariana imovel = this.imobiliaria.getImovel(codigoImovel);

        if (imovel != null)
        {
            String resposta = Input_Utils_CarolineGabrielMariana.lerString(scanner, 
                "Deseja remover o imóvel: '" + codigoImovel + "' (sim/nao) ", true);
                
            while (!resposta.equals("sim") && !resposta.equals("nao"))
            {
                System.err.println("[INPUT-ERROR]: Por favor, responda somente com sim ou nao.");

                resposta = Input_Utils_CarolineGabrielMariana.lerString(scanner, 
                        "Deseja remover o imóvel: '" + codigoImovel + "' (sim/nao) ", true);
            }

            if (resposta.equals("sim"))
            {
                if (this.imobiliaria.removerImovel(imovel))
                {
                    System.out.println("\nImóvel removido com sucesso!");
                }
                else
                {
                    System.out.println("\n[REMOVE-ERROR]: Houve algum problema ao remover o Imóvel.");
                }
            }
            else
            {
                System.out.println("\nImóvel NÃO removido por escolha do usuário.");
            }

            return;
        }

        System.err.println("\n[REMOVER-ERROR]: Não foi possível encontrar o imóvel desejado.");
    }

    private void salvarDados() 
    {
        Serializador_CarolineGabrielMariana.salvarObjeto(imobiliaria.getImoveis(), imobiliaria.getConfiguracoes().getArquivoImoveis());
        System.out.println("\nDados salvos com sucesso!");
    }

}