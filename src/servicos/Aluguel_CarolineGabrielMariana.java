package servicos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import usuarios.Cliente_CarolineGabrielMariana;
import usuarios.Corretor_CarolineGabrielMariana;

import imoveis.Imovel_CarolineGabrielMariana;

import transacoes.Pagamento_CarolineGabrielMariana;


public class Aluguel_CarolineGabrielMariana implements Serializable
{

    private int codigoAluguel;
    private Cliente_CarolineGabrielMariana cliente;
    private Corretor_CarolineGabrielMariana corretor;
    private Imovel_CarolineGabrielMariana imovel;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private LocalDate dataPagamentoMensal;
    private float valorTotalAluguel;
    private Pagamento_CarolineGabrielMariana formaPagamento;
    private ArrayList<Seguro_CarolineGabrielMariana> segurosContratados;
    private boolean finalizado;
    private boolean pago;

    
    public Aluguel_CarolineGabrielMariana()
    {
        this.codigoAluguel = 0;

        this.cliente = new Cliente_CarolineGabrielMariana();

        this.corretor = new Corretor_CarolineGabrielMariana();

        this.imovel = new Imovel_CarolineGabrielMariana();

        this.dataAluguel = null;

        this.dataDevolucao = null;

        this.dataPagamentoMensal = null;

        this.valorTotalAluguel = 0.0f;

        this.formaPagamento = null;

        this.segurosContratados = new ArrayList<Seguro_CarolineGabrielMariana>();

        this.finalizado = false;

        this.pago = false;
    }

    public Aluguel_CarolineGabrielMariana(int codigoAluguel, 
                                        Cliente_CarolineGabrielMariana cliente,
                                        Corretor_CarolineGabrielMariana corretor, 
                                        Imovel_CarolineGabrielMariana imovel, 
                                        LocalDate dataAluguel,
                                        LocalDate dataDevolucao, 
                                        LocalDate dataPagamentoMensal, 
                                        float valorTotalAluguel,
                                        Pagamento_CarolineGabrielMariana formaPagamento,
                                        ArrayList<Seguro_CarolineGabrielMariana> segurosContratados, 
                                        boolean finalizado, 
                                        boolean pago) 
    {
        this.codigoAluguel = codigoAluguel;
        this.cliente = cliente;
        this.corretor = corretor;
        this.imovel = imovel;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.dataPagamentoMensal = dataPagamentoMensal;
        this.valorTotalAluguel = valorTotalAluguel;
        this.formaPagamento = formaPagamento;
        this.segurosContratados = segurosContratados;
        this.finalizado = finalizado;
        this.pago = pago;
    }

    public int getCodigoAluguel() 
    {
        return codigoAluguel;
    }

    public void setCodigoAluguel(int codigoAluguel) 
    {
        this.codigoAluguel = codigoAluguel;
    }

    public Cliente_CarolineGabrielMariana getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente_CarolineGabrielMariana cliente) 
    {
        this.cliente = cliente;
    }

    public Corretor_CarolineGabrielMariana getCorretor() 
    {
        return corretor;
    }

    public void setCorretor(Corretor_CarolineGabrielMariana corretor) 
    {
        this.corretor = corretor;
    }

    public Imovel_CarolineGabrielMariana getImovel() 
    {
        return imovel;
    }

    public void setImovel(Imovel_CarolineGabrielMariana imovel) 
    {
        this.imovel = imovel;
    }

    public LocalDate getDataAluguel() 
    {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) 
    {
        this.dataAluguel = dataAluguel;
    }

    public LocalDate getDataDevolucao() 
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) 
    {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataPagamentoMensal() 
    {
        return dataPagamentoMensal;
    }

    public void setDataPagamentoMensal(LocalDate dataPagamentoMensal) 
    {
        this.dataPagamentoMensal = dataPagamentoMensal;
    }

    public float getValorTotalAluguel() 
    {
        return valorTotalAluguel;
    }

    public Pagamento_CarolineGabrielMariana getFormaPagamento() 
    {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagamento_CarolineGabrielMariana formaPagamento) 
    {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Seguro_CarolineGabrielMariana> getSegurosContratados() 
    {
        return segurosContratados;
    }

    public void setSegurosContratados(ArrayList<Seguro_CarolineGabrielMariana> segurosContratados) 
    {
        this.segurosContratados = segurosContratados;
    }

    public boolean isFinalizado() 
    {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) 
    {
        this.finalizado = finalizado;
    }

    public boolean isPago() 
    {
        return pago;
    }

    public void setPago(boolean pago) 
    {
        this.pago = pago;
    }

    public float calcularValorTotal()
    {
        if(this.possuiSeguro())
        {
            float valorTotal = 0;

            for(Seguro_CarolineGabrielMariana seguro : segurosContratados)
            {
                valorTotal += seguro.getValor();
            }

            this.valorTotalAluguel = valorTotal;

        }

        return this.getValorTotalAluguel();
        
    }

    public boolean possuiSeguro()
    {
        if(segurosContratados.isEmpty())
        {
            return false;
        }

        return true;
    }

    public boolean verificarAtraso()
    {
        LocalDate diaHoje = LocalDate.now();

        if (!finalizado &&
            !pago &&
            diaHoje.isAfter(this.getDataPagamentoMensal())
           )
        {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {

        /* 
        Usei a classe "StringBuilder" a fim de concatenar em uma String todas
         as informações sobre cada um dos seguros que o imóvel possui. 
         */
        StringBuilder stringSeguros = new StringBuilder();

        if(this.possuiSeguro())
        {
            for(Seguro_CarolineGabrielMariana seguro : segurosContratados)
            {
                stringSeguros.append(seguro.toString()).append("\n");        
            }
        }
        else
        {
            stringSeguros.append("O imóvel não possui nenhum seguro!");
        }

        return "{" + 
        "\n Código do aluguel: " + this.getCodigoAluguel() +
        "\n Cliente: " + this.getCliente().getNome() +
        "\n Corretor: " + this.getCorretor().getNome() +
        "\n Imóvel:" +
        "\n    Código do Imóvel: " + this.getImovel().getCodigoImovel() +
        "\n    Endereço do Imóvel: " + this.getImovel().getEndereco() +
        "\n Data do aluguel: " + this.getDataAluguel() +
        "\n Data de Devolução: " + this.getDataDevolucao() +
        "\n Data do pagamento mensal: " + this.getDataPagamentoMensal() +
        "\n Valor total do aluguel: " + this.calcularValorTotal() +
        "\n Forma de pagamento do aluguel: " + this.getFormaPagamento() +
        "\n Seguros Contratados:\n" + stringSeguros + 
        "\n Aluguel finalizado? " + this.isFinalizado() +
        "\n Aluguel está pago? " + this.isPago() +
        "\n Aluguel está atrasado? " + this.verificarAtraso() +
        "\n}";
    }
}
