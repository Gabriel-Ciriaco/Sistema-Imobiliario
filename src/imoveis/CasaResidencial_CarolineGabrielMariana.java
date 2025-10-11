package imoveis;

public class CasaResidencial_CarolineGabrielMariana extends Imovel_CarolineGabrielMariana 
{
    private boolean temGaragem;
    private boolean temJardim;

    public CasaResidencial_CarolineGabrielMariana() 
    {
        super();
        this.temGaragem = false;
        this.temJardim = false;
    }

    public CasaResidencial_CarolineGabrielMariana(String codigoImovel, String endereco,double area, int numeroQuartos, double valor,boolean temGaragem, boolean temJardim) 
    {
        super(codigoImovel, endereco, area, numeroQuartos, valor);
        this.temGaragem = temGaragem;
        this.temJardim = temJardim;
    }

    public boolean isTemGaragem() 
    {
        return temGaragem;
    }

    
    public void setTemGaragem(boolean temGaragem) 
    {
        this.temGaragem = temGaragem;
    }
    

    public boolean isTemJardim()
    {
        return temJardim;
    }

    public void setTemJardim(boolean temJardim) 
    {
        this.temJardim = temJardim;
    }
    
    

    @Override
    public String toString() 
    {
        return "Casa Residencial {" +
                "\n Codigo do Imovel: " + getCodigoImovel() +
                "\n Endereco: " + getEndereco() +
                "\n Area: " + getArea() +
                "\n Numero de Quartos: " + getNumeroQuartos() +
                "\n Valor: " + getValor() +
                "\n Tem Garagem: " + (temGaragem ? "Sim" : "Nao") +
                "\n Tem Jardim: " + (temJardim ? "Sim" : "Nao") +
                "\n}";
    }
    
}