package com.possumus.demo.endpoints.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CurriculumDto extends BaseDto{

	private String base64;
}
