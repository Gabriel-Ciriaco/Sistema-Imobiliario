package imoveis;

import java.io.Serializable;

public class Imovel_CarolineGabrielMariana implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private String codigoImovel;
    private String endereco;
    private double area;
    private int numeroQuartos;
    private double valor;

    public Imovel_CarolineGabrielMariana() 
    {
        this.codigoImovel = "";
        this.endereco = "";
        this.area = 0.0f;
        this.numeroQuartos = 0;
        this.valor = 0.0f;
    }

    public Imovel_CarolineGabrielMariana(String codigoImovel, String endereco, double area, int numeroQuartos, double valor)
    {
        this.codigoImovel = codigoImovel;
        this.endereco = endereco;
        this.area = area;
        this.numeroQuartos = numeroQuartos;
        this.valor = valor;
    }

    public String getCodigoImovel() 
    {
        return codigoImovel;
    }

    
    public void setCodigoImovel(String codigoImovel) 
    {
        this.codigoImovel = codigoImovel;
    }

    
    public String getId() 
    {
        return this.codigoImovel;
    }
    
    
    public String getEndereco()
    {
        return endereco;
    }

    
    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }

    
    public double getArea() 
    {
        return area;
    }
    
    

    public void setArea(double area) 
    {
        this.area = area;
    }

    public int getNumeroQuartos() 
    {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) 
    {
        this.numeroQuartos = numeroQuartos;
    }

    
    public double getValor() 
    {
        return valor;
    }
    

    public void setValor(double valor) 
    {
        this.valor = valor;
    }
    
    

    @Override
    public String toString() 
    {
        return "{" +
                "\n Codigo do Imovel: " + codigoImovel +
                "\n Endereco: " + endereco +
                "\n Area: " + area +
                "\n Numero de Quartos: " + numeroQuartos +
                "\n Valor: " + valor +
                "\n}";
    }
}
