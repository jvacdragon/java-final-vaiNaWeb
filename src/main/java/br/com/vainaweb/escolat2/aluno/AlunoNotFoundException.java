package br.com.vainaweb.escolat2.aluno;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
