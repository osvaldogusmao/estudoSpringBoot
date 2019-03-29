package br.com.osvaldogusmao.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.osvaldogusmao.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class DefaultErrorHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<DefaultError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
