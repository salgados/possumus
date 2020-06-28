package com.possumus.demo.endpoints.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ContactDto extends BaseDto{
	
	private String email;
	
	private String phone;
}
