package com.elumini.desafiovr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityBusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntityBusinessException(String mensagem) {
		super(mensagem);
	}
}
