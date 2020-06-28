package com.possumus.demo.endpoints.mappers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.mapstruct.Mapper;
import com.possumus.demo.endpoints.dto.CurriculumDto;
import com.possumus.demo.persistence.entities.Curriculum;

@Mapper()
public interface CurriculumMapper {
	CurriculumDto entityToDto(Curriculum curriculum);
	Curriculum dtoToEntity(CurriculumDto curriculum);
	
	default byte[] toBytes(String base64) throws IOException {
        return base64.getBytes();
    }	
	
	default String toString(byte[] base64encoded) {
		return new String(base64encoded, StandardCharsets.UTF_8);
	}
}
