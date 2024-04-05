package br.com.vainaweb.escolat2.colaborador;

import br.com.vainaweb.escolat2.endereco.Endereco;

public record ColaboradorDTO(String name, String email, String cpf, String cargo, Endereco endereco) {


}
