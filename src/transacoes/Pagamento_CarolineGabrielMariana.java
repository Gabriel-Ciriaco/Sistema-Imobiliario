package transacoes;

import java.io.Serializable;

public abstract class Pagamento_CarolineGabrielMariana implements Serializable
{

    private String tipoPagamento;

    
    public Pagamento_CarolineGabrielMariana()
    {
        this.tipoPagamento = "";
    }

    public Pagamento_CarolineGabrielMariana(String tipoPagamento) 
    {
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento() 
    {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) 
    {
        this.tipoPagamento = tipoPagamento;
    }

    public abstract String toString();
    
}
