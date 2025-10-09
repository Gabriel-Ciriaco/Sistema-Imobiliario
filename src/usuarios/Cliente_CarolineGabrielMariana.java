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
       return String.format("{codigoUsuario=%d,nome=%s, cpf=%s, rg=%s, dataNascimento=%s, endereco=%s, cep=%s, telefone=%s, email=%s, dataCadastro=%s}",
                             codigoUsuario, nome, cpf, rg, dataNascimento.toString(), endereco, cep, telefone, email, dataCadastro.toString());  
    }
    
    
    
}
