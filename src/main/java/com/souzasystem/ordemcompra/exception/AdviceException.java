package com.souzasystem.ordemcompra.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AdviceException {

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handlerException(ConstraintViolationException ex, HttpServletRequest request) {
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURI());
		System.out.println("ERROR - FELIPE1 - "+ex.getSQLException());
		System.out.println("ERROR - FELIPE2 - "+ex.getConstraintName());
		System.out.println("ERROR - FELIPE3 - "+ex.getErrorCode());
		System.out.println("ERROR - FELIPE4 - "+ex.getSQL());
		System.out.println("ERROR - FELIPE5 - "+ex.getSQLState());
		System.out.println("ERROR - FELIPE6 - "+ex.getSQLException().getErrorCode());
		System.out.println("ERROR - FELIPE7 - "+ex.getSQLException().getLocalizedMessage().split(" "));
		
		return null;
	}
}
