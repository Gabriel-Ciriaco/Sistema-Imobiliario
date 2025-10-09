package transacoes;

public class Dinheiro_CarolineGabrielMariana extends Pagamento_CarolineGabrielMariana
{

    private float valorEntregue;


    public Dinheiro_CarolineGabrielMariana()
    {
        super("dinheiro");

        this.valorEntregue = 0.0f;
    }

    public Dinheiro_CarolineGabrielMariana(float valorEntregue) 
    {
        super("dinheiro");
        this.valorEntregue = valorEntregue;
    }

    public float getValorEntregue() 
    {
        return valorEntregue;
    }

    public void setValorEntregue(float valorEntregue) 
    {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public String toString() 
    {
        return "Valor entregue: " + this.getValorEntregue();
    }
    
}
