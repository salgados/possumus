package com.possumus.demo.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5836029192262707336L;
	
	public SkillNotFoundException(Long id) {
	    super("Could not find Skill " + id);
	  }

}