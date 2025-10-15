package imobiliaria;

import java.util.ArrayList;

import configuracoes.Configuracao_CarolineGabrielMariana;
import configuracoes.Desserializador_CarolineGabrielMariana;
import imoveis.Imovel_CarolineGabrielMariana;

import servicos.Aluguel_CarolineGabrielMariana;
import servicos.Seguro_CarolineGabrielMariana;
import servicos.Venda_CarolineGabrielMariana;

import usuarios.Cliente_CarolineGabrielMariana;
import usuarios.Corretor_CarolineGabrielMariana;



public class Imobiliaria_CarolineGabrielMariana
{
    private String nome;
    
    private String endereco;


    private ArrayList<Aluguel_CarolineGabrielMariana> alugueis;

    private ArrayList<Venda_CarolineGabrielMariana> vendas;

    private ArrayList<Imovel_CarolineGabrielMariana> imoveis;

    private ArrayList<Cliente_CarolineGabrielMariana> clientes;

    private ArrayList<Corretor_CarolineGabrielMariana> corretores;

    private ArrayList<Seguro_CarolineGabrielMariana> seguros;

    private Configuracao_CarolineGabrielMariana configuracoes;


    public Imobiliaria_CarolineGabrielMariana()
    {
        this.nome = "";

        this.endereco = "";

        this.configuracoes = new Configuracao_CarolineGabrielMariana();

        this.alugueis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoAlugueis());

        this.vendas = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoVendas());

        this.imoveis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoImoveis());
        
        this.clientes = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoClientes());
        
        this.corretores = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoCorretores());

        this.seguros = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoSeguros());
    }

    public Imobiliaria_CarolineGabrielMariana(String nome, String endereco)
    {
        this.nome = nome;

        this.endereco = endereco;
        
        this.configuracoes = new Configuracao_CarolineGabrielMariana();

        this.alugueis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoAlugueis());

        this.vendas = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoVendas());

        this.imoveis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoImoveis());
        
        this.clientes = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoClientes());
        
        this.corretores = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoCorretores());

        this.seguros = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoSeguros());
    }

    public Imobiliaria_CarolineGabrielMariana(
            String nome, String endereco,
            ArrayList<Aluguel_CarolineGabrielMariana> alugueis, ArrayList<Venda_CarolineGabrielMariana> vendas,
            ArrayList<Imovel_CarolineGabrielMariana> imoveis, ArrayList<Cliente_CarolineGabrielMariana> clientes,
            ArrayList<Corretor_CarolineGabrielMariana> corretores, ArrayList<Seguro_CarolineGabrielMariana> seguros,
            Configuracao_CarolineGabrielMariana configuracoes
        )
    {
        this.nome = nome;
        
        this.endereco = endereco;

        this.alugueis = alugueis;


        this.vendas = vendas;

        this.imoveis = imoveis;

        this.clientes = clientes;

        this.corretores = corretores;

        this.seguros = seguros;

        this.configuracoes = configuracoes;

        this.alugueis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoAlugueis());

        this.vendas = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoVendas());

        this.imoveis = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoImoveis());
        
        this.clientes = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoClientes());
        
        this.corretores = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoCorretores());

        this.seguros = Desserializador_CarolineGabrielMariana.carregarObjeto(this.configuracoes.getArquivoSeguros());
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public ArrayList<Aluguel_CarolineGabrielMariana> getAlugueis() {
        return alugueis;
    }


    public void setAlugueis(ArrayList<Aluguel_CarolineGabrielMariana> alugueis) {
        this.alugueis = alugueis;
    }


    public ArrayList<Venda_CarolineGabrielMariana> getVendas() {
        return vendas;
    }


    public void setVendas(ArrayList<Venda_CarolineGabrielMariana> vendas) {
        this.vendas = vendas;
    }


    public ArrayList<Imovel_CarolineGabrielMariana> getImoveis() {
        return imoveis;
    }


    public void setImoveis(ArrayList<Imovel_CarolineGabrielMariana> imoveis) {
        this.imoveis = imoveis;
    }


    public ArrayList<Cliente_CarolineGabrielMariana> getClientes() {
        return clientes;
    }


    public void setClientes(ArrayList<Cliente_CarolineGabrielMariana> clientes) {
        this.clientes = clientes;
    }


    public ArrayList<Corretor_CarolineGabrielMariana> getCorretores() {
        return corretores;
    }


    public void setCorretores(ArrayList<Corretor_CarolineGabrielMariana> corretores) {
        this.corretores = corretores;
    }


    public ArrayList<Seguro_CarolineGabrielMariana> getSeguros() {
        return seguros;
    }


    public void setSeguros(ArrayList<Seguro_CarolineGabrielMariana> seguros) {
        this.seguros = seguros;
    }


    public Configuracao_CarolineGabrielMariana getConfiguracoes() {
        return configuracoes;
    }


    public void setConfiguracoes(Configuracao_CarolineGabrielMariana configuracoes) {
        this.configuracoes = configuracoes;
    }

    public Imovel_CarolineGabrielMariana getImovel(int codigoImovel)
    {
        for (Imovel_CarolineGabrielMariana imovel : this.imoveis)
        {
            if (imovel.getCodigoImovel() == codigoImovel)
            {
                return imovel;
            }
        }

        return null;
    }

    public boolean removerImovel(Imovel_CarolineGabrielMariana imovel)
    {        
        return this.imoveis.remove(imovel);
    }
    
    public Cliente_CarolineGabrielMariana getCliente(int codigoUsuario)
    {
        for (Cliente_CarolineGabrielMariana cliente : clientes)
        {
            if (codigoUsuario == cliente.getCodigoUsuario())
                return cliente;
        }

        return null;
    }

    public Corretor_CarolineGabrielMariana getCorretor(int codigoUsuario)
    {
        for (Corretor_CarolineGabrielMariana corretor : corretores)
        {
            if (codigoUsuario == corretor.getCodigoUsuario())
                return corretor;
        }

        return null;
    }

    public ArrayList<Aluguel_CarolineGabrielMariana> getAlugueisClientes(int codigoUsuario)
    {
        ArrayList<Aluguel_CarolineGabrielMariana> alugueisCliente = new ArrayList<Aluguel_CarolineGabrielMariana>();

        for (Aluguel_CarolineGabrielMariana aluguel : this.alugueis)
        {
            if (aluguel.getCliente().getCodigoUsuario() == codigoUsuario)
            {
                alugueisCliente.add(aluguel);
            }
        }

        return !alugueisCliente.isEmpty() ? alugueisCliente : null;
    }

    public ArrayList<Venda_CarolineGabrielMariana> getComprasClientes(int codigoUsuario)
    {
        ArrayList<Venda_CarolineGabrielMariana> comprasCliente = new ArrayList<Venda_CarolineGabrielMariana>();

        for (Venda_CarolineGabrielMariana venda : this.vendas)
        {
            if (venda.getCliente().getCodigoUsuario() == codigoUsuario)
            {
                comprasCliente.add(venda);
            }
        }

        return !comprasCliente.isEmpty() ? comprasCliente : null;
    }

    public ArrayList<Imovel_CarolineGabrielMariana> getImoveisCliente(int codigoUsuario)
    {
        ArrayList<Imovel_CarolineGabrielMariana> imoveisCliente = new ArrayList<Imovel_CarolineGabrielMariana>();

        for (Venda_CarolineGabrielMariana venda : vendas)
        {
            if (venda.getCliente().getCodigoUsuario() == codigoUsuario)
                imoveisCliente.add(venda.getImovel());
        }

        return !imoveisCliente.isEmpty() ? imoveisCliente : null;
    }

    
}
