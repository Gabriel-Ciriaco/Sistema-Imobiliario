package sistema;

import configuracoes.Serializador_CarolineGabrielMariana;

import imobiliaria.Imobiliaria_CarolineGabrielMariana;
import imoveis.*;
import servicos.Aluguel_CarolineGabrielMariana;
import servicos.Seguro_CarolineGabrielMariana;
import servicos.Venda_CarolineGabrielMariana;
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
            System.out.println("4. Alugar Imóvel");
            System.out.println("5. Vender Imóvel");
            System.out.println("6. Opções de Listagens");
            System.out.println("7. Remover Imóvel");
            System.out.println("8. Salvar Dados");
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
                    alugarImoveis();
                    break;
                case 5:
                    //venderImovel();
                    break;
                case 6:
                    opcoesDeListagem();
                    break;
                case 7:
                    removerImovel();
                    break;
                case 8:
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
        System.out.println("Selecione os seguros que deseja adicionar: ");

        System.out.println("1. Cobertura total contra roubo");
        
        System.out.println("2. Cobertura contra enchentes");

        System.out.println("3. Cobertura contra incêndios residenciais");

        System.out.println("4. Cobertura total: roubo, incêndio, enchente, colisões e desastres naturais");

        System.out.println("5. Nenhum.");

        int codigoSeguro = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Seguro: ");
        
        ArrayList<Seguro_CarolineGabrielMariana> seguros = new ArrayList<Seguro_CarolineGabrielMariana>();

        while (codigoSeguro != 5)
        {
            Seguro_CarolineGabrielMariana seguroSelecionado = imobiliaria.getSeguro(codigoSeguro);

            if (seguroSelecionado != null)
            {
                seguros.add(seguroSelecionado);
            }
            else
            {
                System.out.println("Seguro não selecionado.");
            }
        }
        
        return seguros;       
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
            System.out.println("\n[ALUGAR-ERROR]: Corretor não encontrado. Por favor, tente novamente.");
            
            codigoUsuarioCorretor = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do corretor: ");

            corretor = this.imobiliaria.getCorretor(codigoUsuarioCorretor);
        }

        int codigoUsuarioCliente = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do cliente: ");

        Cliente_CarolineGabrielMariana cliente = this.imobiliaria.getCliente(codigoUsuarioCliente);

        while(cliente == null)
        {
            System.out.println("\n[ALUGAR-ERROR]: Cliente não encontrado. Por favor, tente novamente.");
            
            codigoUsuarioCliente = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código de usuário do cliente: ");

            cliente = this.imobiliaria.getCliente(codigoUsuarioCliente);

        }
        
        int codigoImovel = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Código do Imóvel: ");

        Imovel_CarolineGabrielMariana imovel = this.imobiliaria.getImovel(codigoImovel);

        while(imovel== null)
        {
            System.out.println("\n[ALUGAR-ERROR]: Imóvel não encontrado. Por favor, tente novamente.");
            
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


        if (this.imobiliaria.getAlugueis() != null)
            this.imobiliaria.getAlugueis().add(novoAluguel);
        else
            System.err.println("\n[ALUGAR-IMOVEIS]: Ocorreu um erro interno ao alugar o imóvel.");
    }

    private void opcoesDeListagem() 
    {
        System.out.println("Escolha a opção de listagem desejada:");
        System.out.println("1. Listar todos os Imóveis cadastrados");
        System.out.println("2. Listar todos os Imóveis de categoria Casa Residencial");
        System.out.println("3. Listar todos os Imóveis de categoria Prédio Residencial");
        System.out.println("4. Listar todos os Imóveis de categoria Comercial");
        System.out.println("5. Listar todos os Imóveis disponíveis para locação");
        System.out.println("6. Listar todos os Imóveis alugados");
        System.out.println("7. Listar todos os Imóveis disponíveis para vendas");
        System.out.println("8. Listar todos os Imóveis vendidos");
        System.out.println("9. Listar todos os Imóveis com atraso no pagamento do aluguel");
        System.out.println("10. Listar todos os Imóveis já alugados por um Cliente em específico");
        System.out.println("11. Listar todos os Imóveis já comprados por um Cliente em específico");
        System.out.println("12. Listar todos os Corretores cadastrados");
        System.out.println("13. Listar todos os Clientes cadastrados");
        System.out.println("14. Listar Clientes com aluguéis em atraso");
        System.out.println("15. Listar todos os Aluguéis finalizados");
        System.out.println("16. Listar todos os Aluguéis ainda dentro do prazo de locação");
        System.out.println("17. Listar todas as Vendas realizadas");
        System.out.println("18. Listar Vendas realizadas em um mês específico e total de lucro no mês");
        System.out.println("19. Listar todos os tipos de Seguros cadastrados");

        int opcao = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite a opção desejada: ");

        switch (opcao) 
        {
            case 1:
                listarImoveisCadastrados();
                break;
            case 2:
                listarImoveisCasaResidencial();
                break;
            case 3:
                listarImoveisPredioResidencial();
                break;
            case 4:
                listarImoveisComercial();
                break;
            case 5:
                listarImoveisDisponiveisParaLocacao();
                break;
            case 6:
                listarImoveisAlugados();
                break;
            case 7:
                listarImoveisDisponiveisParaVenda();
                break;
            case 8:
                listarImoveisVendidos();
                break;
            case 9:
                listarImoveisComAluguelEmAtraso();
                break;
            case 10:
                listarImoveisAlugadosPorCliente();
                break;
            case 11:
                listarImoveisCompradosPorCliente();
                break;
            case 12:
                listarCorretoresCadastrados();
                break;
            case 13:
                listarClientesCadastrados();
                break;
            case 14:
                listarClientesComAluguelEmAtraso();
                break;
            case 15:
                listarAlugueisFinalizados();
                break;
            case 16:
                listarAlugueisDentroDoPrazo();
                break;
            case 17:
                listarVendasRealizadas();
                break;
            case 18:
                listarVendasPorMesComLucro();
                break;
            case 19:
                listarSegurosCadastrados();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void listarImoveisCadastrados() 
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

    private void listarImoveisCasaResidencial()
    {
        ArrayList<CasaResidencial_CarolineGabrielMariana> casasResidenciais = this.imobiliaria.getCasasResidenciais();

        if (casasResidenciais == null)
        {
            System.out.println("\n[LISTAR-CASAS-RESIDENCIAS]: Não há casas residenciais cadastradas.");

            return;
        }

        System.out.println("\n\n--- Lista de Casas Residenciais  ---");
        for (CasaResidencial_CarolineGabrielMariana casaResidencial : casasResidenciais) 
        {
            System.out.println("\n" + casaResidencial.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);

    }
    private void listarImoveisPredioResidencial()
    {
        ArrayList<PredioResidencial_CarolineGabrielMariana> prediosResidenciais = this.imobiliaria.getPredioResidenciais();

        if (prediosResidenciais == null)
        {
            System.out.println("\n[LISTAR-PREDIOS-RESIDENCIAS]: Não há prédios residenciais cadastradas.");

            return;
        }

        System.out.println("\n\n--- Lista de Prédios Residenciais  ---");

        for (PredioResidencial_CarolineGabrielMariana predioResidencial : prediosResidenciais) 
        {
            System.out.println("\n" + predioResidencial.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarImoveisComercial()
    {
        ArrayList<Comercial_CarolineGabrielMariana> comerciais = this.imobiliaria.getComerciais();

        if (comerciais == null)
        {
            System.out.println("\n[LISTAR-IMOVEIS-COMERCIAIS]: Não há imóveis comerciais cadastradas.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Comerciais  ---");

        for (Comercial_CarolineGabrielMariana comercial : comerciais) 
        {
            System.out.println("\n" + comercial.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);

    }

    private void listarImoveisDisponiveisParaLocacao() 
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = this.imobiliaria.getImoveisDisponiveisLocacao();

        if (imoveis == null)
        {
            System.out.println("\n[LISTAR-IMOVEIS-DISPONIVEIS-PARA-LOCACAO]: Não há imóveis disponíveis para locação cadastradas.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Disponíveis para Locação  ---");

        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
            System.out.println("\n" + imovel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }

    
    private void listarImoveisAlugados()
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = this.imobiliaria.getImoveisAlugados();

        if (imoveis == null)
        {
            System.out.println("\n[LISTAR-IMOVEIS-ALUGADOS]: Não há imóveis alugados. ");
            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Alugados  ---");

        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
            System.out.println("\n" + imovel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarImoveisDisponiveisParaVenda()
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = this.imobiliaria.getImoveisDisponiveisVenda();

        if (imoveis == null)
        {
            System.out.println("\n[LISTAR-IMOVEIS-DISPONIVEIS-PARA-VENDA]: Não há imóveis disponíveis para venda cadastrados.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Disponíveis para Venda  ---");

        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
            System.out.println("\n" + imovel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarImoveisVendidos()
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = this.imobiliaria.getImoveisVendidos();

        if (imoveis == null)
        {
            System.out.println("\n[LISTAR-IMOVEIS-VENDIDOS]: Não há imóveis vendidos cadastrados.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Vendidos  ---");

        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
            System.out.println("\n" + imovel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarImoveisComAluguelEmAtraso()
    {
        ArrayList<Aluguel_CarolineGabrielMariana> alugueis = this.imobiliaria.getAlugueisAtrasados();

        if (alugueis.isEmpty())
        {
            System.out.println("\n[LISTAR-IMOVEIS-COM-ALUGUEL-EM-ATRASO]: Não há imóveis com aluguel em atraso.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Com Aluguel em Atraso  ---");

        for (Aluguel_CarolineGabrielMariana aluguel : alugueis) 
        {
            System.out.println("\n" + aluguel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarImoveisAlugadosPorCliente()
    {

        int codigoUsuario = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite o código do usuário: ");
        ArrayList<Aluguel_CarolineGabrielMariana> alugueis = this.imobiliaria.getAlugueisClientes(codigoUsuario);

        if (alugueis.isEmpty())
        {
            System.out.println("\n[LISTAR-IMOVEIS-ALUGADOS-POR-CLIENTE]: Não há imóveis alugados por esse cliente.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Alugados por Cliente  ---");

        for (Aluguel_CarolineGabrielMariana aluguel : alugueis) 
        {
            System.out.println("\n" + aluguel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);

    }


    private void listarImoveisCompradosPorCliente()
    {
        int codigoUsuario = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite o código do usuário: ");
        ArrayList<Venda_CarolineGabrielMariana> vendas = this.imobiliaria.getComprasClientes(codigoUsuario);

        if (vendas.isEmpty())
        {
            System.out.println("\n[LISTAR-IMOVEIS-COMPRADOS-POR-CLIENTE]: Não há imóveis comprados por esse cliente.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Comprados por Cliente  ---");

        for (Venda_CarolineGabrielMariana venda : vendas) 
        {
            System.out.println("\n" + venda.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarCorretoresCadastrados()
    {
        ArrayList<Corretor_CarolineGabrielMariana> corretores = this.imobiliaria.getCorretores();

        if (corretores.isEmpty())
        {
            System.out.println("\n[LISTAR-CORRETORES]: Não há corretores cadastrados.");

            return;
        }

        System.out.println("\n\n--- Lista de Corretores Cadastrados  ---");

        for (Corretor_CarolineGabrielMariana corretor : corretores) 
        {
            System.out.println("\n" + corretor.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarClientesCadastrados() 
    {
        ArrayList<Cliente_CarolineGabrielMariana> clientes = this.imobiliaria.getClientes();

        if (clientes.isEmpty())
        {
            System.out.println("\n[LISTAR-CLIENTES-CADASTRADOS]: Não há clientes cadastrados.");

            return;
        }

        System.out.println("\n\n--- Lista de Clientes Cadastrados  ---");

        for (Cliente_CarolineGabrielMariana cliente : clientes) 
        {
            System.out.println("\n" + cliente.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }

    private void listarClientesComAluguelEmAtraso() 
    {
        ArrayList<Cliente_CarolineGabrielMariana> clientes = this.imobiliaria.getClientesAlugueisAtrasados();

        if (clientes.isEmpty())
        {
            System.out.println("\n[LISTAR-CLIENTES-COM-ALUGUEL-EM-ATRASO]: Não há clientes com alugueis em atraso.");

            return;
        }

        System.out.println("\n\n--- Lista de Clientes com Aluguel em Atraso  ---");

        for (Cliente_CarolineGabrielMariana cliente : clientes) 
        {
            System.out.println("\n" + cliente.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }

    private void listarAlugueisFinalizados()
    {
        ArrayList<Aluguel_CarolineGabrielMariana> alugueis = this.imobiliaria.getAlugueisFinalizados();

        if (alugueis.isEmpty())
        {
            System.out.println("\n[LISTAR-IMOVEIS-FINALIZADOS]: Não há alugueis finalizados.");

            return;
        }

        System.out.println("\n\n--- Lista de Alugueis Finalizados  ---");

        for (Aluguel_CarolineGabrielMariana aluguel : alugueis) 
        {
            System.out.println("\n" + aluguel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }

    private void listarAlugueisDentroDoPrazo()
    {
        ArrayList<Aluguel_CarolineGabrielMariana> alugueis = this.imobiliaria.getAlugueisPrazoLocacao();

        if (alugueis.isEmpty())
        {
            System.out.println("\n[LISTAR-ALUGUEIS-DENTRO-PRAZO]: Não há imóveis alugados que estão dentro do prazo.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Alugados que estão dentro do Prazo ---");

        for (Aluguel_CarolineGabrielMariana aluguel : alugueis) 
        {
            System.out.println("\n" + aluguel.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarVendasRealizadas()
    {
        ArrayList<Venda_CarolineGabrielMariana> vendas = this.imobiliaria.getVendas();

        if (vendas.isEmpty())
        {
            System.out.println("\n[LISTAR-VENDAS-REALIZADAS]: Não há nenhuma venda realizada.");

            return;
        }

        System.out.println("\n\n--- Lista de Vendas Realizadas ---");

        for (Venda_CarolineGabrielMariana venda : vendas) 
        {
            System.out.println("\n" + venda.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


    private void listarVendasPorMesComLucro()
    {
        int mes = Input_Utils_CarolineGabrielMariana.lerInt(scanner, "Digite o mês: ");

        ArrayList<Venda_CarolineGabrielMariana> vendas = this.imobiliaria.getVendasMes(mes);

        if (vendas.isEmpty())
        {
            System.out.println("\n[LISTAR-VENDAS-POR-MES]: Não há vendas nesse mês.");

            return;
        }

        System.out.println("\n\n--- Lista de Imóveis Vendidos no Mês ---");

        for (Venda_CarolineGabrielMariana venda : vendas) 
        {
            System.out.println("\n" + venda.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }

    private void listarSegurosCadastrados()
    {
        ArrayList<Seguro_CarolineGabrielMariana> seguros = this.imobiliaria.getSeguros();

        if (seguros.isEmpty())
        {
            System.out.println("\n[LISTAR-SEGUROS-CADASTRADOS]: Não há seguros cadastrados.");

            return;
        }

        System.out.println("\n\n--- Lista de Seguros Cadastrados  ---");

        for (Seguro_CarolineGabrielMariana seguro : seguros) 
        {
            System.out.println("\n" + seguro.toString() + '\n');
        }

        Input_Utils_CarolineGabrielMariana.lerString(scanner, "Pressione qualquer botão para continuar... ", false);
    }


}