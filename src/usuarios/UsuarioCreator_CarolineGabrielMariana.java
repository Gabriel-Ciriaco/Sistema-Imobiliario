/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import java.time.LocalDate;

public class UsuarioCreator_CarolineGabrielMariana {
    public static Usuario_CarolineGabrielMariana criarUsuario(
            int tipo, int codigoUsuario, String nome, String cpf, String rg,
            LocalDate dataNascimento, String endereco, String cep, String telefone, 
            String email, String identificador, float salario, String pis, 
            LocalDate dataEspecial) {
        
        UserFactory_CarolineGabrielMariana factory;

        switch (tipo) {
            case 1: // Cliente
                factory = new ClienteFactory_CarolineGabrielMariana(
                    codigoUsuario, nome, cpf, rg, dataNascimento, 
                    endereco, cep, telefone, email, dataEspecial
                );
                break;
            case 2: // Corretor
                factory = new CorretorFactory_CarolineGabrielMariana(
                    codigoUsuario, nome, cpf, rg, dataNascimento,
                    endereco, cep, telefone, email, identificador, 
                    salario, pis, dataEspecial
                );
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }

        return factory.criarUsuario();
    }
}