package com.souzasmaurilio.sitepsicologia.recursos.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.souzasmaurilio.sitepsicologia.servico.exception.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ManipuladorDeExcecoes {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(System.currentTimeMillis(), status.value(), "não encontrado", e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
