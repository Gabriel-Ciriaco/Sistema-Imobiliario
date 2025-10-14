package imoveis;

import java.time.LocalDate;

public class CasaResidencial_CarolineGabrielMariana extends Imovel_CarolineGabrielMariana
{
    public CasaResidencial_CarolineGabrielMariana()
    {
        super();
    }

    public CasaResidencial_CarolineGabrielMariana(int codigoImovel, String endereco, LocalDate dataConstrucao,
            float areaTotal, float areaConstruida, int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem,
            float valorIPTU, float valorVenda, float valorAluguel)
    {
        super(codigoImovel, endereco, dataConstrucao, areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros,
                qtdVagasGaragem, valorIPTU, valorVenda, valorAluguel);
    }
    
}
