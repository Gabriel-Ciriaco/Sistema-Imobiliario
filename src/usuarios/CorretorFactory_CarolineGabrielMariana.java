/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.time.LocalDate;

public class CorretorFactory_CarolineGabrielMariana implements UserFactory_CarolineGabrielMariana {
    private int codigoUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String endereco;
    private String cep;
    private String telefone;
    private String email;
    private String creci;
    private float salario;
    private String pis;
    private LocalDate dataAdmissao;

    public CorretorFactory_CarolineGabrielMariana(int codigoUsuario, String nome, String cpf, String rg,
                                                  LocalDate dataNascimento, String endereco, String cep,
                                                  String telefone, String email, String creci, float salario,
                                                  String pis, LocalDate dataAdmissao) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.creci = creci;
        this.salario = salario;
        this.pis = pis;
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public Corretor_CarolineGabrielMariana criarUsuario() {
        return new Corretor_CarolineGabrielMariana(
            codigoUsuario, nome, cpf, rg, dataNascimento, endereco, cep,
            telefone, email, creci, salario, pis, dataAdmissao
        );
    }
}