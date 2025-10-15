package usuarios;

import java.time.LocalDate;


public class Corretor_CarolineGabrielMariana extends Usuario_CarolineGabrielMariana
{
    protected String creci;

    protected float salario;

    protected String pis;

    protected LocalDate dataAdmissao;

    
    public Corretor_CarolineGabrielMariana()
    {
        super();

        this.creci = "";

        this.salario = 0.0f;

        this.pis = "";

        this.dataAdmissao = null;
    }


    
    public Corretor_CarolineGabrielMariana(
        Usuario_CarolineGabrielMariana usuario,
        String creci, float salario, String pis, LocalDate dataAdmissao)
    {
        super(usuario.getCodigoUsuario(), usuario.getNome(), usuario.getCpf(), 
            usuario.getRg(), usuario.getDataNascimento(), usuario.getEndereco(), 
            usuario.getCep(), usuario.getTelefone(), usuario.getEmail());
        this.creci = creci;
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }



    public Corretor_CarolineGabrielMariana(
                int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco,
                String cep, String telefone, String email, String creci, float salario, String pis,
                LocalDate dataAdmissao
            )
    {
        super(codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep, telefone, email);
        this.creci = creci;
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }

    public String getCreci()
    {
        return creci;
    }

    public void setCreci(String creci)
    {
        this.creci = creci;
    }

    public float getSalario()
    {
        return salario;
    }

    public void setSalario(float salario)
    {
        if (salario >= 0)
            this.salario = salario;
    }

    public String getPis()
    {
        return pis;
    }

    public void setPis(String pis)
    {
        this.pis = pis;
    }

    public LocalDate getDataAdmissao()
    {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao)
    {
        this.dataAdmissao = dataAdmissao;
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
        "\n CRECI: " + this.creci +
        "\n Salário: " + this.salario + 
        "\n PIS: " + this.pis +
        "\n Data de Admissão: " + this.dataAdmissao.toString() +
        "\n}";
    }
}
