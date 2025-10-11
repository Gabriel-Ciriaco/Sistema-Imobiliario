package imobiliaria;

import configuracoes.Serializador_CarolineGabrielMariana;
import imoveis.*;
import servicos.*;
import usuarios.*;
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
        inicializarListasVazias();
    }
    
    

    private void inicializarListasVazias() 
    {
        
        if (imobiliaria.getAlugueis() == null) 
        {
            imobiliaria.setAlugueis(new ArrayList<Aluguel_CarolineGabrielMariana>());
        }
        
        
        if (imobiliaria.getVendas() == null)
        {
            imobiliaria.setVendas(new ArrayList<Venda_CarolineGabrielMariana>());
        }
        
        if (imobiliaria.getImoveis() == null) 
        {
            imobiliaria.setImoveis(new ArrayList<Imovel_CarolineGabrielMariana>());
        }
        
        
        if (imobiliaria.getClientes() == null) 
        {
            imobiliaria.setClientes(new ArrayList<Cliente_CarolineGabrielMariana>());
        }
        
        
        if (imobiliaria.getCorretores() == null)
        {
            imobiliaria.setCorretores(new ArrayList<Corretor_CarolineGabrielMariana>());
        }
        
        if (imobiliaria.getSeguros() == null) 
        {
            imobiliaria.setSeguros(new ArrayList<Seguro_CarolineGabrielMariana>());
        }
        
    }

    
    
    public void executar() 
    {
        int opcao;
        do 
        {
            System.out.println("\n--- Sistema Imobiliaria ---");
            System.out.println("1. Cadastrar Imovel");
            System.out.println("2. Listar Imoveis");
            System.out.println("3. Salvar Dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) 
            {
                case 1:
                    cadastrarImovel();
                    break;
                case 2:
                    listarImoveis();
                    break;
                case 3:
                    salvarDados();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarImovel() 
    {
        System.out.println("\n\nTipos de Imovel:");
        System.out.println("1. Casa Residencial");
        System.out.println("2. Comercial");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Codigo do Imovel: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();
        
        System.out.print("Area: ");
        double area = scanner.nextDouble();
        
        System.out.print("Numero de Quartos: ");
        int quartos = scanner.nextInt();
        
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        
        scanner.nextLine();

        if (tipo == 1) 
        {
            System.out.print("Tem garagem? (true/false): ");
            boolean garagem = scanner.nextBoolean();
            System.out.print("Tem jardim? (true/false): ");
            boolean jardim = scanner.nextBoolean();
            
            CasaResidencial_CarolineGabrielMariana casa = new CasaResidencial_CarolineGabrielMariana(
                codigo, endereco, area, quartos, valor, garagem, jardim);
            imobiliaria.getImoveis().add(casa);
        }
        
        else if (tipo == 2) 
        {
            System.out.print("\nTipo Comercial: ");
            String tipoComercial = scanner.nextLine();
            
            System.out.print("Numero de Salas: ");
            int salas = scanner.nextInt();
            
            Comercial_CarolineGabrielMariana comercial = new Comercial_CarolineGabrielMariana(codigo, endereco, area, quartos, valor, tipoComercial, salas);imobiliaria.getImoveis().add(comercial);
        }
        
        System.out.println("Imovel cadastrado com sucesso!");
    }
    
    

    private void listarImoveis() 
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveis = imobiliaria.getImoveis();
        
        if (imoveis.isEmpty()) 
        {
            System.out.println("Nao ha imoveis cadastrados.");
            return;
        }   

        System.out.println("\n\n--- Lista de Imoveis ---");
        for (Imovel_CarolineGabrielMariana imovel : imoveis) 
        {
        System.out.println(imovel.toString());
        }
    }

    private void salvarDados() 
    {
        Serializador_CarolineGabrielMariana.salvarObjeto(imobiliaria.getImoveis(), imobiliaria.getConfiguracoes().getArquivoImoveis());
        System.out.println("Dados salvos com sucesso!");
    }

    public static void main(String[] args) 
    {
        Sistema_CarolineGabrielMariana sistema = new Sistema_CarolineGabrielMariana();
        sistema.executar();
    }
}