package configuracoes;


import java.io.ObjectInputStream;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.Serializable;

import java.lang.ClassNotFoundException;



public class Desserializador_CarolineGabrielMariana
{

    @SuppressWarnings("unchecked") // Remove o aviso de cast inseguro.
    public static <T extends Serializable> T carregarObjeto(String caminhoArquivo)
    {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(caminhoArquivo)))
        {
            return (T) in.readObject(); // Fazemos o casting para retornamos a classe corretamente.
        }
        catch (IOException | ClassNotFoundException error)
        {
            System.err.println("[DESSERIALIZADOR]: Erro ao carregar objeto: " + error.getMessage());
            return null;
        }
    }
}