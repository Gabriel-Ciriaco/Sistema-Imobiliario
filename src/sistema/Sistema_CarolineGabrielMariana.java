package sistema;

import configuracoes.Serializador_CarolineGabrielMariana;

import imobiliaria.Imobiliaria_CarolineGabrielMariana;
import imoveis.*;
import servicos.Aluguel_CarolineGabrielMariana;
import servicos.Seguro_CarolineGabrielMariana;
import transacoes.Cartao_CarolineGabrielMariana;
import transacoes.Dinheiro_CarolineGabrielMariana;
import transacoes.Pagamento_CarolineGabrielMariana;
import usuarios.Cliente_CarolineGabrielMariana;
import usuarios.Corretor_CarolineGabrielMariana;
import usuarios.Usuario_CarolineGabrielMariana;

import java.time.LocalDate;
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
            System.out.println("1. Cadastrar Corretor");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Cadastrar Imóvel");
            System.out.println("4. Listar Imoveis");
            System.out.println("5. Remover Imóvel");
            System.out.println("6. Salvar Dados");
            System.out.println("0. Sair");
            
            opcao = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Escolha uma opção: ");


            switch (opcao) 
            {
                case 1:
                    cadastrarCorretor();
                    salvarDados();
                    break;
                case 2:
                    cadastrarCliente();
                    salvarDados();
                    break;
                case 3:
                    cadastrarImovel();
                    salvarDados();
                    break;
                case 4:
                    listarImoveis();
                    break;
                case 5:
                    removerImovel();
                    break;
                case 6:
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
                                                    "1. Casa Residencial\n2. Prédio Residencial\n3. Comercial\nEscolha o tipo: "
                                                            );
                                                           
        int codigoImovel = Input_Utils_CarolineGabrielMariana.lerInt(scanner,"Código do Imóvel: ");
 
        String endereco = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                              "Endereço do Imóvel: ",
                                                         true
                                                                      );

        LocalDate dataConstrucao = Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
         "Data de Construção (Formato: YYYY-MM-DD): ");

        float areaTotal = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Área Total do Imóvel: ");
        
        float areaConstruida = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Área Construida do Imóvel: ");
        
        int qtdDormitorios = Input_Utils_CarolineGabrielMariana.lerInt(scanner,
                                                        "Número de Quartos: "
                                                               );

        int qtdBanheiros = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Número de Banheiros: ");

        int qtdVagasGaragem = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Número de Vagas de Garagem: ");

        float valorIPTU = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Valor do IPTU: ");

        float valorVenda = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Valor de Venda: ");
        
        float valorAluguel = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Valor de Aluguel: ");
        
        Imovel_CarolineGabrielMariana novoImovel = null;

        switch (tipo)
        {
            case 1:
                novoImovel =
                 (CasaResidencial_CarolineGabrielMariana) new CasaResidencial_CarolineGabrielMariana(codigoImovel,
                  endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem,
                   valorIPTU, valorVenda, valorAluguel);

                break;
            
            case 2:
                int andar = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Andar do Imóvel: ");
                float valorCondominio = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Valor do Condomínio: ");

                novoImovel = (PredioResidencial_CarolineGabrielMariana) new PredioResidencial_CarolineGabrielMariana(
                    codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros,
                     qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel, andar, valorCondominio);

                break;
            
            case 3:
                float taxaImpostoFederal = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Taxa do Imposto Federal: ");
    
                novoImovel = (Comercial_CarolineGabrielMariana) new Comercial_CarolineGabrielMariana(codigoImovel, endereco,
                 dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem,
                  valorIPTU, valorVenda, valorAluguel, taxaImpostoFederal);

                break;            
            
        }

        if (novoImovel == null)
            System.err.println("\n[CADASTRO-IMÓVEL-ERROR]: Houve algum erro interno ao cadastra o imóvel");

        if (imobiliaria.getImoveis() != null)
        {
            imobiliaria.getImoveis().add(novoImovel);
            System.out.println("Imovel cadastrado com sucesso!");
        }
        else
            System.out.println("\n[CADASTRAR-IMOVEL-ERROR]: Houve algum problema ao cadastrar o imóvel.\n");
        
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
        int codigoImovel = Input_Utils_CarolineGabrielMariana.lerInt(
            scanner, "\nDigite o código do Imóvel: ");
        
        Imovel_CarolineGabrielMariana imovel = this.imobiliaria.getImovel(codigoImovel);

        if (imovel != null)
        {
            String resposta = Input_Utils_CarolineGabrielMariana.lerString(scanner, 
                "Deseja remover o imóvel: '" + codigoImovel + "' (sim/nao) ", false);
                
            while (!resposta.equals("sim") && !resposta.equals("nao"))
            {
                System.err.println("[INPUT-ERROR]: Por favor, responda somente com sim ou nao.");

                resposta = Input_Utils_CarolineGabrielMariana.lerString(scanner, 
                        "Deseja remover o imóvel: '" + codigoImovel + "' (sim/nao) ", false);
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

    private Usuario_CarolineGabrielMariana cadastrarUsuario()
    {
        int codigoUsuario = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Usuário: ");
        
        String nome = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Nome do Usuário: ", true);

        String cpf = Input_Utils_CarolineGabrielMariana.lerString(scanner, "CPF: ", false);

        String rg = Input_Utils_CarolineGabrielMariana.lerString(scanner, "RG: ", false);

        LocalDate dataNascimento = Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
        "Data de Nascimento (Formato: YYYY-MM-DD): ");

        String endereco = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Endereço: ", true);
        
        String cep = Input_Utils_CarolineGabrielMariana.lerString(scanner, "CEP: ", false);
        
        String telefone = Input_Utils_CarolineGabrielMariana.lerString(scanner, "Telefone: ", false);

        String email = Input_Utils_CarolineGabrielMariana.lerString(scanner, "E-mail: ", false);

        return new Usuario_CarolineGabrielMariana(
            codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
    }

        private void cadastrarCorretor()
    {
        String creci = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                              "Creci do corretor: ",
                                                         false
                                                                      );

        float salario = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Salário do corretor: ");

        String pis = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                              "Pis do corretor: ",
                                                         false
                                                                      );
        LocalDate dataAdmissao = Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
                                                "Data de Admissão (Formato: YYYY-MM-DD): ");
        
        Corretor_CarolineGabrielMariana novoCorretor = new Corretor_CarolineGabrielMariana(
            this.cadastrarUsuario(), creci, salario, pis, dataAdmissao);

        this.imobiliaria.getCorretores().add(novoCorretor);
        
    }

    private void cadastrarCliente()
    {
        Cliente_CarolineGabrielMariana novoCliente = new Cliente_CarolineGabrielMariana(
            this.cadastrarUsuario(), LocalDate.now());
        
        this.imobiliaria.getClientes().add(novoCliente);
        
    }

    private ArrayList<Seguro_CarolineGabrielMariana> selecionarSeguros()
    {
        int codigoSeguro = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Seguro: ");
        


        return null;
        
    }

    private Cartao_CarolineGabrielMariana cadastrarCartaoCliente()
    {
        String nome = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                              "Nome no cartão: ",
                                                         true
                                                                      );

        String bandeira = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                                      "Bandeira do cartão: ",
                                                                 true
                                                                              );

        String numero = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                                                                              "Número do cartão: ",
                                                                         false
                                                                                      );

        Cartao_CarolineGabrielMariana cartao = new Cartao_CarolineGabrielMariana(nome, bandeira, numero);

        return cartao;
    }

    private void alugarImoveis()
    {
        int codigoUsuarioCorretor = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do corretor: ");

        Corretor_CarolineGabrielMariana corretor = this.imobiliaria.getCorretor(codigoUsuarioCorretor);

        while(corretor == null)
        {
            System.out.println("\n[ALUGAR-ERROR]: Corretor não entrado. Por favor, tente novamente.");
            
            codigoUsuarioCorretor = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do corretor: ");

            corretor = this.imobiliaria.getCorretor(codigoUsuarioCorretor);
        }

        int codigoUsuarioCliente = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do cliente: ");

        Cliente_CarolineGabrielMariana cliente = this.imobiliaria.getCliente(codigoUsuarioCliente);

        while(cliente == null)
        {
            System.out.println("\n[ALUGAR-ERROR]: Cliente não entrado. Por favor, tente novamente.");
            
            codigoUsuarioCliente = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do cliente: ");

            cliente = this.imobiliaria.getCliente(codigoUsuarioCliente);

        }
        
        int codigoImovel = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Imóvel: ");

        Imovel_CarolineGabrielMariana imovel = this.imobiliaria.getImovel(codigoImovel);

        while(imovel== null)
        {
            System.out.println("\n[ALUGAR-ERROR]: Imóvel não entrado. Por favor, tente novamente.");
            
            codigoImovel = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Imóvel: ");

            imovel = this.imobiliaria.getImovel(codigoImovel);

        }

        int codigoAluguel = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de Aluguel: ");

        LocalDate dataAluguel= Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
        "Data de Aluguel (Formato: YYYY-MM-DD): ");

        LocalDate dataDevolucao = Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
        "Data de Devolução (Formato: YYYY-MM-DD): ");

        LocalDate dataPagamentoMensal = Input_Utils_CarolineGabrielMariana.lerLocalDate(scanner,
        "Data de Pagamento Mensal (Formato: YYYY-MM-DD): ");

        float valorTotalAluguel = Input_Utils_CarolineGabrielMariana.lerFloat(scanner, "Valor Total do Aluguel: ");

        int selecionarFormaPagamento = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite a forma de Pagamento (1-Cartão e 2-Dinheiro): ");

        Pagamento_CarolineGabrielMariana formaPagamento = null;

        while (selecionarFormaPagamento != 1 || selecionarFormaPagamento != 2) 
        {
            System.out.println("[ALUGAR-ERROR]: Por favor, digite um valor válido (1 ou 2).");

            selecionarFormaPagamento = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite a forma de Pagamento (1-Cartão e 2-Dinheiro): ");
            
        }
        switch (selecionarFormaPagamento)
        {
            
            case 1:

                formaPagamento = (Pagamento_CarolineGabrielMariana) cadastrarCartaoCliente();

                break;

            case 2:

                String tipoMoeda = Input_Utils_CarolineGabrielMariana.lerString(scanner,
                    "Tipo da moeda: ",
                    true
                    );

                formaPagamento = (Pagamento_CarolineGabrielMariana) new Dinheiro_CarolineGabrielMariana(tipoMoeda);

                break;
        }

        Aluguel_CarolineGabrielMariana novoAluguel = new Aluguel_CarolineGabrielMariana(codigoAluguel, cliente, 
                                                    corretor, imovel, dataAluguel, dataDevolucao, dataPagamentoMensal, 
                                                    valorTotalAluguel, formaPagamento , this.selecionarSeguros(), false, false);


    }
}