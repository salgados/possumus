package com.possumus.demo.service.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5836029192262707336L;
	
	public CandidateNotFoundException(Long id) {
	    super("Could not find Candidate " + id);
	  }

}
