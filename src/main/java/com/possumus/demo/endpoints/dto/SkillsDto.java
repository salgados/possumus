package com.possumus.demo.endpoints.dto;

import java.util.List;
import lombok.Data;

@Data
public class SkillsDto {
	private Long idCandidate;
	private List<SkillDto> skills;
}
