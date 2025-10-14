package transacoes;

public class Dinheiro_CarolineGabrielMariana extends Pagamento_CarolineGabrielMariana
{

   private String tipoDeMoeda;


    public Dinheiro_CarolineGabrielMariana()
    {
        super("dinheiro");

        this.tipoDeMoeda = "";
    }

    public Dinheiro_CarolineGabrielMariana(String tipoDeMoeda) 
    {
        super("dinheiro");
        this.tipoDeMoeda = tipoDeMoeda;
    }

    public String getTipoDeMoeda() 
    {
        return tipoDeMoeda;
    }

    public void setTipoDeMoeda(String tipoDeMoeda) 
    {
        this.tipoDeMoeda = tipoDeMoeda;
    }

    @Override
    public String toString() 
    {
        return "Tipo de moeda: " + this.getTipoDeMoeda();
    }
    
}
