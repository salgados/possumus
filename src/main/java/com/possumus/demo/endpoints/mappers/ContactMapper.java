package com.possumus.demo.endpoints.mappers;

import org.mapstruct.Mapper;

import com.possumus.demo.endpoints.dto.ContactDto;
import com.possumus.demo.persistence.entities.Contact;

@Mapper()
public interface ContactMapper {
	ContactDto entityToDto(Contact contact);
	Contact dtoToEntity(ContactDto contact);
}
