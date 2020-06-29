package com.possumus.demo.endpoints.mappers;

import java.util.List;

import org.joda.time.Interval;
import org.mapstruct.Mapper;

import com.possumus.demo.endpoints.dto.WorkDto;
import com.possumus.demo.persistence.entities.WorkHistory;

@Mapper(uses= {CandidateMapper.class})
public interface WorkMapper {
	WorkDto entityToDto(WorkHistory work);
	WorkHistory dtoToEntity(WorkDto work);
	
	List<WorkDto> entitiesToDtos(List<WorkHistory> work);
	List<WorkHistory> dtosToEntities(List<WorkDto> work);
}
