package imoveis;

import java.time.LocalDate;

public class PredioResidencial_CarolineGabrielMariana extends Imovel_CarolineGabrielMariana 
{
    protected int andar;
    protected float valorCondominio;


    public PredioResidencial_CarolineGabrielMariana() 
    {
        super();

        this.andar = 0;
        this.valorCondominio = 0.0f;
    }

    public PredioResidencial_CarolineGabrielMariana(int codigoImovel, String endereco, LocalDate dataConstrucao,
            float areaTotal, float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem,
            float valorIPTU, float valorVenda, float valorAluguel, int andar, float valorCondominio) {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros,
                qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel);
     
        this.andar = andar;
        this.valorCondominio = valorCondominio;
    }


    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public float getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public float getValorAluguel()
    {
        return this.getValorAluguel();
    }

    @Override
    public String toString() 
    {
        return "{" +
                "\n Codigo do Imovel: " + codigoImovel +
                "\n Endereco: " + endereco +
                "\n Data de Construção: " + this.dataConstrucao +
                "\n Área Total: " + this.areaTotal +
                "\n Área Construída: " + this.areaConstruida +
                "\n Número de Dormitórios: " + this.qtdDormitorios +
                "\n Número de Banheiros: " + this.qtdBanheiros +
                "\n Número de Vagas de Garagem: " + this.qtdVagasGaragem +
                "\n Valor IPTU: " + this.valorIPTU +
                "\n Valor Venda: " + this.valorVenda +
                "\n Valor Aluguel: " + this.valorAluguel +
                "\n Número de Andares: " + this.andar +
                "\n Valor do Condomínio: " + this.valorCondominio +
                "\n}";
    }
}