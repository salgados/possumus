package com.possumus.demo.endpoints.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SkillDto extends BaseDto{
	private CandidateDto candidate;
	
	private String technology;
	private String experience;
}
