/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.time.LocalDate;

public class ClienteFactory_CarolineGabrielMariana implements UserFactory_CarolineGabrielMariana {
    private int codigoUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String endereco;
    private String cep;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;

    public ClienteFactory_CarolineGabrielMariana(int codigoUsuario, String nome, String cpf, String rg, 
                                                 LocalDate dataNascimento, String endereco, String cep, 
                                                 String telefone, String email, LocalDate dataCadastro) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public Cliente_CarolineGabrielMariana criarUsuario() {
        return new Cliente_CarolineGabrielMariana(
            codigoUsuario, nome, cpf, rg, dataNascimento, 
            endereco, cep, telefone, email, dataCadastro
        );
    }
}