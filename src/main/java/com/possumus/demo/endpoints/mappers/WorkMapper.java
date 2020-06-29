package com.possumus.demo.endpoints.mappers;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.possumus.demo.endpoints.dto.WorkDto;
import com.possumus.demo.persistence.entities.WorkHistory;

@Mapper(uses= {CandidateMapper.class})
public interface WorkMapper {
	WorkDto entityToDto(WorkHistory work);
	WorkHistory dtoToEntity(WorkDto work);
	
	List<WorkDto> entitiesToDtos(List<WorkHistory> work);
	List<WorkHistory> dtosToEntities(List<WorkDto> work);
	
	@AfterMapping
	default void toInterval(WorkDto workDto, @MappingTarget WorkHistory work) {
		DateTime start = new DateTime(workDto.getStartDate());
		DateTime end = new DateTime(workDto.getEndDate()!=null? workDto.getEndDate(): DateTime.now());
		Interval interval = new Interval(start, end);
	    work.setWorkInterval(interval);
	}
	
	@AfterMapping
	default void toDate(@MappingTarget WorkDto workDto, WorkHistory work) {
		workDto.setStartDate(work.getWorkInterval().getStart().toDate());
		workDto.setEndDate(work.getWorkInterval().getEnd().toDate());
	    
	}
}
