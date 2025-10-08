package servicos;

import java.time.LocalDate;

import usuarios.Cliente_CarolineGabrielMariana;
import usuarios.Corretor_CarolineGabrielMariana;
import transacoes.Pagamento_CarolineGabrielMariana;

import imoveis.Imovel_CarolineGabrielMariana;


public class Venda_CarolineGabrielMariana 
{
    private int codigoVenda;
    private Cliente_CarolineGabrielMariana cliente;
    private Corretor_CarolineGabrielMariana corretor;
    private Imovel_CarolineGabrielMariana imovel;
    private LocalDate dataVenda;
    private float valorTotalVenda;
    private Pagamento_CarolineGabrielMariana formaPagamento;
    private boolean finalizada;

    public Venda_CarolineGabrielMariana(int codigoVenda, 
                                        Cliente_CarolineGabrielMariana cliente,
                                        Corretor_CarolineGabrielMariana corretor, 
                                        Imovel_CarolineGabrielMariana imovel, 
                                        LocalDate dataVenda,
                                        float valorTotalVenda, 
                                        Pagamento_CarolineGabrielMariana formaPagamento, 
                                        boolean finalizada) 
    {
        this.codigoVenda = codigoVenda;
        this.cliente = cliente;
        this.corretor = corretor;
        this.imovel = imovel;
        this.dataVenda = dataVenda;
        this.valorTotalVenda = valorTotalVenda;
        this.formaPagamento = formaPagamento;
        this.finalizada = finalizada;
    }

    public int getCodigoVenda() 
    {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) 
    {
        this.codigoVenda = codigoVenda;
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

    public LocalDate getDataVenda() 
    {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) 
    {
        this.dataVenda = dataVenda;
    }

    public float getValorTotalVenda() 
    {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(float valorTotalVenda) 
    {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Pagamento_CarolineGabrielMariana getFormaPagamento() 
    {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagamento_CarolineGabrielMariana formaPagamento) 
    {
        this.formaPagamento = formaPagamento;
    }

    public boolean isFinalizada() 
    {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) 
    {
        this.finalizada = finalizada;
    }

    @Override
    public String toString() 
    {
        return "Código da venda: " + this.getCodigoVenda() +
        "\n Cliente: " + this.getCliente().getNome() +
        "\n Corretor: " + this.getCorretor().getNome() + 
        "\n Imóvel: " + this.getImovel().getId() + 
        "\n Data da venda: " + this.getDataVenda() +
        "\n Valor total da venda: " + this.getValorTotalVenda() +
        "\n Forma de pagamento: " + this.getFormaPagamento() +
        "\n Venda finalizada? " + this.isFinalizada();
    }

    
    
    
}
