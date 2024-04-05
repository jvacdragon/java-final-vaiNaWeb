package br.com.vainaweb.escolat2.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {
    INSTRUTOR, FACILITADOR, COORDENACAO, ADMINISTRATIVO;

    @JsonCreator
    public static Cargo fromString(String cargo){
        for(Cargo c : Cargo.values() ){
            if(c.name().equalsIgnoreCase(cargo)) return c;
        }
        throw new IllegalArgumentException("Valor inválido para cargo");
    }
}
