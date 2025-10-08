package usuarios;


import java.io.Serializable;

import java.time.LocalDate;



public class Usuario_CarolineGabrielMariana  implements Serializable
{
    // Versão da classe serializável.
    private static final long serialVersionUID = 1L;
    
    protected int codigoUsuario;

    protected String nome;

    protected String cpf;
    
    protected String rg;

    protected LocalDate dataNascimento;

    protected String endereco;
    
    protected String cep;
    
    protected String telefone;
    
    protected String email;


    public Usuario_CarolineGabrielMariana(int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco,
            String cep, String telefone, String email)
    {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
    }



    public int getCodigoUsuario()
    {
        return codigoUsuario;
    }



    public void setCodigoUsuario(int codigoUsuario)
    {
        this.codigoUsuario = codigoUsuario;
    }



    public String getNome()
    {
        return nome;
    }



    public void setNome(String nome)
    {
        this.nome = nome;
    }



    public String getCpf()
    {
        return cpf;
    }



    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }



    public String getRg()
    {
        return rg;
    }



    public void setRg(String rg)
    {
        this.rg = rg;
    }



    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }



    public void setDataNascimento(LocalDate dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }



    public String getEndereco()
    {
        return endereco;
    }



    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }



    public String getCep()
    {
        return cep;
    }



    public void setCep(String cep)
    {
        this.cep = cep;
    }



    public String getTelefone()
    {
        return telefone;
    }



    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }



    public String getEmail()
    {
        return email;
    }



    public void setEmail(String email)
    {
        this.email = email;
    }



    public String toString()
    {
        return String.format("{codigoUsuario=%d, nome=%s, cpf=%s, rg=%s, dataNascimento=%s, endereco=%s, cep=%s, telefone=%s, email=%s}",
                             codigoUsuario, nome, cpf, rg, dataNascimento.toString(), endereco, cep, telefone, email);    
    }
    
}