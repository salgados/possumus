package com.possumus.demo.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5836029192262707336L;
	
	public WorkNotFoundException(Long id) {
	    super("Could not find Work " + id);
	  }

}
