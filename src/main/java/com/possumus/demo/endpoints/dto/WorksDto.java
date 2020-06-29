package com.possumus.demo.endpoints.dto;

import java.util.List;

import lombok.Data;

@Data
public class WorksDto {
	private Long idCandidate;
	private List<WorkDto> works;
}
