import java.util.ArrayList;

import configuracoes.Serializador_CarolineGabrielMariana;
import imoveis.Imovel_CarolineGabrielMariana;
import servicos.Aluguel_CarolineGabrielMariana;
import servicos.Seguro_CarolineGabrielMariana;
import servicos.Venda_CarolineGabrielMariana;
import sistema.Sistema_CarolineGabrielMariana;
import usuarios.Cliente_CarolineGabrielMariana;
import usuarios.Corretor_CarolineGabrielMariana;

public class Main
{
    public static void main(String[] args) {

        Sistema_CarolineGabrielMariana sistema = new Sistema_CarolineGabrielMariana();
        sistema.executar();

        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Aluguel_CarolineGabrielMariana>(), "arquivos/alugueis.bin");
        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Cliente_CarolineGabrielMariana>(), "arquivos/clientes.bin");
        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Corretor_CarolineGabrielMariana>(), "arquivos/corretores.bin");
        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Imovel_CarolineGabrielMariana>(), "arquivos/imoveis.bin");
        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Venda_CarolineGabrielMariana>(), "arquivos/vendas.bin");
        //Serializador_CarolineGabrielMariana.salvarObjeto(new ArrayList<Seguro_CarolineGabrielMariana>(), "arquivos/seguros.bin");

    }
}
