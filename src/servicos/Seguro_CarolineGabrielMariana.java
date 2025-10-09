package servicos;

public class Seguro_CarolineGabrielMariana
{
    private int codigoSeguro;
    private String nomeSeguradora;
    private String tipo;
    private String descricao;
    private float valor;

    public Seguro_CarolineGabrielMariana()
    {
        this.codigoSeguro = 0;

        this.nomeSeguradora = "";

        this.tipo = "";

        this.descricao = "";

        this.valor = 0.0f;
    }

    public Seguro_CarolineGabrielMariana(int codigoSeguro, String nomeSeguradora, 
                                        String tipo, String descricao,float valor) 
    {
        this.codigoSeguro = codigoSeguro;
        this.nomeSeguradora = nomeSeguradora;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigoSeguro() 
    {
        return codigoSeguro;
    }

    public void setCodigoSeguro(int codigoSeguro) 
    {
        this.codigoSeguro = codigoSeguro;
    }

    public String getNomeSeguradora() 
    {
        return nomeSeguradora;
    }

    public void setNomeSeguradora(String nomeSeguradora) 
    {
        this.nomeSeguradora = nomeSeguradora;
    }

    public String getTipo() 
    {
        return tipo;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public float getValor() 
    {
        return valor;
    }

    public void setValor(float valor) 
    {
        this.valor = valor;
    }

    /* 
    Esse método 'toString' é herdado da classe Object. 
    Aqui estamos sobreescrevendo ele (tipo de polimorfismo)
    */
    @Override
    public String toString()
    {
        return "{" +
                "\nCódigo do seguro: " + this.getCodigoSeguro() + 
                "\n Nome da seguradora: " + this.getNomeSeguradora() +
                "\n Tipo do seguro: " + this.getTipo() +
                "\n Descrição do seguro: " + this.getDescricao() +
                "\n Valor do seguro: " + this.getValor() +
                "\n}";
    }
}