/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.time.LocalDate;

public class UsuarioCreator_CarolineGabrielMariana
{
    public static Usuario_CarolineGabrielMariana criarUsuario(
            int tipo, int codigoUsuario, String nome, String cpf, String rg,
            LocalDate dataNascimento, String endereco, String cep, String telefone, 
            String email, String creci, Float salario,
            String pis, LocalDate dataAdmissao) {

        switch (tipo) {
            case 1: // Cliente
                return new Cliente_CarolineGabrielMariana(
                    codigoUsuario,
                    nome,
                    cpf,
                    rg,
                    dataNascimento,
                    endereco,
                    cep,
                    telefone,
                    email,
                    LocalDate.now()
                );

            case 2: // Corretor
                return new Corretor_CarolineGabrielMariana(
                    codigoUsuario, nome, cpf, rg, dataNascimento,
                    endereco, cep, telefone, email, creci, salario, pis, dataAdmissao);

            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }
}