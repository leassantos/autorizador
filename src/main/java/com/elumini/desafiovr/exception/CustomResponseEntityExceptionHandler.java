package com.elumini.desafiovr.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<DetalheErros> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		DetalheErros detalheErros = new DetalheErros(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<DetalheErros>(detalheErros,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntidadeExistenteException.class)
	public final ResponseEntity<DetalheErros> handleEntidadeExistenteException(Exception ex, WebRequest request) throws Exception {
		DetalheErros detalheErros = new DetalheErros(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<DetalheErros>(detalheErros,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(EntityBusinessException.class)
	public final ResponseEntity<DetalheErros> handleEntityBusinessException(Exception ex, WebRequest request) throws Exception {
		DetalheErros detalheErros = new DetalheErros(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<DetalheErros>(detalheErros,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public final ResponseEntity<DetalheErros> handleEntidadeNaoEncontradaException(Exception ex, WebRequest request) throws Exception {
		DetalheErros detalheErros = new DetalheErros(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<DetalheErros>(detalheErros,HttpStatus.NOT_FOUND);
	}
}
