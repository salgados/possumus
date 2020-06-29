package com.possumus.demo.endpoints.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class WorkDto extends BaseDto{
	
	private CandidateDto candidate;
	
	private String company;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date endDate;
}
