package com.souzasmaurilio.sitepsychologist.resourse.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.souzasmaurilio.sitepsychologist.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ExceptionHamdler {
	
	@ExceptionHandler(ObjectNotFoundException .class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "não encontrado", e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
