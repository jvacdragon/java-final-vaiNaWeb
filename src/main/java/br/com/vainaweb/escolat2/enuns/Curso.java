package br.com.vainaweb.escolat2.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Curso {
    BACKEND,FRONTEND, DBA;

    @JsonCreator
    public static Curso fromString(String curso){
        for(Curso c : Curso.values()){
            if(c.name().equalsIgnoreCase(curso)) return c;
        }
        throw new IllegalArgumentException("Curso inválido.");
    }
}
