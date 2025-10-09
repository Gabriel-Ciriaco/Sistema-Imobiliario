package usuarios;

import java.time.LocalDate;


public class Cliente_CarolineGabrielMariana extends Usuario_CarolineGabrielMariana
{
    protected LocalDate dataCadastro;

    public Cliente_CarolineGabrielMariana()
    {
        super();

        this.dataCadastro = null;
    }

    public Cliente_CarolineGabrielMariana(
            int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco,
            String cep, String telefone, String email, LocalDate dataCadastro
        )
    {
        super(codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
        this.dataCadastro = dataCadastro;
    }

    
    public LocalDate getDataCadastro()
    {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro)
    {
        this.dataCadastro = dataCadastro;
    }


    @Override
    public String toString() {
        return "{" +
        "\n Código de Usuário: " + this.codigoUsuario + 
        "\n Nome: " + this.nome + 
        "\n CPF: " + this.cpf +
        "\n RG: " + this.rg +
        "\n Data de Nascimento: " + (dataNascimento != null ? dataNascimento.toString() : "null") +
        "\n Endereço: " + this.endereco +
        "\n CEP: " + this.cep + 
        "\n Telefone: " + this.telefone +
        "\n E-mail: " + this.email +
        "\n Data de Cadastro: " + (this.dataCadastro != null ? dataNascimento.toString() : "null") +
        "\n}";
    }
    
    
    
}
