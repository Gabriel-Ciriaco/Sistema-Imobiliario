package usuarios;

import java.time.LocalDate;


public class Corretor_CarolineGabrielMariana extends Usuario_CarolineGabrielMariana
{
    protected String creci;

    protected float salario;

    protected String pis;

    protected LocalDate dataAdmissao;

    
    public Corretor_CarolineGabrielMariana(int codigoUsuario, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco,
            String cep, String telefone, String email, String creci, float salario, String pis,
            LocalDate dataAdmissao)
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
       return String.format(
                            java.util.Locale.US,
                            "{codigoUsuario=%d, nome=%s, cpf=%s, rg=%s, dataNascimento=%s, endereco=%s, cep=%s, telefone=%s, email=%s, creci=%s, salario=%.2f, pis=%s, dataAdmissao=%s}",
                             codigoUsuario,
                             nome,
                             cpf,
                             rg,
                             dataNascimento.toString(),
                             endereco,
                             cep,
                             telefone,
                             email,
                             creci,
                             salario,
                             pis,
                             dataAdmissao.toString());  
    }
    
}
