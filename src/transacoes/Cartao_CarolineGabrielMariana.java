package transacoes;

public class Cartao_CarolineGabrielMariana extends Pagamento_CarolineGabrielMariana
{

    private String nome;
    private String bandeira;
    private String numero;

    public Cartao_CarolineGabrielMariana(String nome, 
                                        String bandeira, 
                                        String numero) 
    {
        super("cartao");
        this.nome = nome;
        this.bandeira = bandeira;
        this.numero = numero;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getBandeira() 
    {
        return bandeira;
    }

    public void setBandeira(String bandeira) 
    {
        this.bandeira = bandeira;
    }

    public String getNumero() 
    {
        return numero;
    }

    public void setNumero(String numero) 
    {
        this.numero = numero;
    }

    @Override
    public String toString()
    {
        return "Nome do cartão: " + this.getNome() +
        "\n Bandeira do cartão: " + this.getBandeira() +
        "\n Número do cartão: " + this.getNumero();
    }

}
