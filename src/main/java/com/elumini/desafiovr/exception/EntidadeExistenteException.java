package com.elumini.desafiovr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
public class EntidadeExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntidadeExistenteException(String mensagem) {
		super(mensagem);
	}
}
