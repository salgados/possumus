package com.possumus.demo.endpoints.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CandidateDto extends BaseDto{
	
	private String firstname;
	
	private String lastname;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date birthdate;
	
	private ContactDto contact;
	
	private CurriculumDto curriculum;

}
