package imoveis;

public class Comercial_CarolineGabrielMariana extends Imovel_CarolineGabrielMariana 
{
    private String tipoComercial;
    private int numeroSalas;

    public Comercial_CarolineGabrielMariana() 
    {
        super();
        this.tipoComercial = "";
        this.numeroSalas = 0;
    }

    public Comercial_CarolineGabrielMariana(String codigoImovel, String endereco, double area, int numeroQuartos, double valor,String tipoComercial, int numeroSalas) 
    {
        super(codigoImovel, endereco, area, numeroQuartos, valor);
        this.tipoComercial = tipoComercial;
        this.numeroSalas = numeroSalas;
    }
    

    public String getTipoComercial()
    {
        return tipoComercial;
    }

    
    public void setTipoComercial(String tipoComercial) 
    {
        this.tipoComercial = tipoComercial;
    }

    
    public int getNumeroSalas() 
    {
        return numeroSalas;
    }

    
    public void setNumeroSalas(int numeroSalas) 
    {
        this.numeroSalas = numeroSalas;
    }

    
    @Override
    public String toString() 
    {
        return "Comercial {" +
                "\n Codigo do Imovel: " + getCodigoImovel() +
                "\n Endereco: " + getEndereco() +
                "\n Area: " + getArea() +
                "\n Numero de Quartos: " + getNumeroQuartos() +
                "\n Valor: " + getValor() +
                "\n Tipo Comercial: " + tipoComercial +
                "\n Numero de Salas: " + numeroSalas +
                "\n}";
    }
}