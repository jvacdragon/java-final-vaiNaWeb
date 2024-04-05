package br.com.vainaweb.escolat2.aluno;

import br.com.vainaweb.escolat2.endereco.Endereco;

public record AlunoDTO (String name, String email, String cpf, String curso, String telefone, Endereco endereco){
}
