package configuracoes;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;

import java.io.Serializable;


public class Serializador_CarolineGabrielMariana
{
    public static <T extends Serializable> void salvarObjeto(T objeto, String caminhoArquivo)
    {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(caminhoArquivo)))
        {
            out.writeObject(objeto);
            System.out.println("[SERIALIZADOR]: Objeto salvo com sucesso em: " + caminhoArquivo);
        }
        catch (IOException error)
        {
            System.err.println("[SERIALIZADOR]: Erro ao salvar objeto: " + error.getMessage());
        }
    }
}