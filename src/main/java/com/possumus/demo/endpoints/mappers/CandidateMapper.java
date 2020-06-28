package com.possumus.demo.endpoints.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.possumus.demo.endpoints.dto.CandidateDto;
import com.possumus.demo.persistence.entities.Candidate;

@Mapper(uses = {CurriculumMapper.class, ContactMapper.class})
public interface CandidateMapper {
	
	CandidateDto entityToDto(Candidate candidate);
	Candidate dtoToEntity(CandidateDto candidateDto);
	List<CandidateDto> entitiesToDtos(List<Candidate> candidates);
	List<Candidate> dtosToEntities(List<CandidateDto> candidates);
}
