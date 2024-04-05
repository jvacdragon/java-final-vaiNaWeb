package br.com.vainaweb.escolat2.colaborador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ColaboradorNotFoundException extends RuntimeException{
    public ColaboradorNotFoundException(String message) {
        super(message);
    }
}
