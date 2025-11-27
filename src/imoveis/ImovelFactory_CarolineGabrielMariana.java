package imoveis;

import java.time.LocalDate;

public class ImovelFactory_CarolineGabrielMariana 
{
    public static Imovel_CarolineGabrielMariana criarImovel(int tipoImovel, int codigoImovel, 
                    String endereco, LocalDate dataConstrucao, float areaTotal, float areaConstruida, 
                    int qtdDormitorios, int qtdBanheiros, int qtdVagasGaragem, float valorIPTU, 
                    float valorVenda, float valorAluguel, Integer andar, Float valorCondominio,
                    Float taxaImpostoFederal)
    {
        switch (tipoImovel) 
        {
            case 1:

                return new CasaResidencial_CarolineGabrielMariana(codigoImovel, endereco, dataConstrucao, 
                            areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem, 
                            valorIPTU, valorVenda, valorAluguel);
                
            case 2:

                return new Comercial_CarolineGabrielMariana(codigoImovel, endereco, dataConstrucao, 
                            areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem, 
                            valorIPTU, valorVenda, valorAluguel, taxaImpostoFederal);

            case 3:

                return new PredioResidencial_CarolineGabrielMariana(codigoImovel, endereco, dataConstrucao, 
                            areaTotal, areaConstruida, qtdDormitorios, qtdBanheiros, qtdVagasGaragem, valorIPTU, 
                            valorVenda, valorAluguel, andar, valorCondominio);
            default:

                System.out.println("Tipo de imóvel inexistente!");
                return null;
        }
    }
}
