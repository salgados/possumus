package com.possumus.demo.endpoints.mappers;

import java.time.Period;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.possumus.demo.endpoints.dto.SkillDto;
import com.possumus.demo.endpoints.dto.SkillsDto;
import com.possumus.demo.persistence.entities.Candidate;
import com.possumus.demo.persistence.entities.Skill;

@Mapper(uses= {CandidateMapper.class})
public interface SkillMapper {
	@Mapping(source="skill.candidate", target="candidate")
	SkillDto entityToDto(Skill skill);
	Skill dtoToEntity(SkillDto skillDto);
	
	List<SkillDto> entitiesToDtos(List<Skill> skills);
	List<Skill> dtosToEntities(List<SkillDto> skillDtos);
	
	default  List<SkillDto> toSkillDtos(SkillsDto skillsDto) {
		return skillsDto.getSkills();
	}
	
	default Period toPeriod(String textPeriod) {
		return Period.parse(textPeriod);
	}
	
	default String toText(Period period) {
		return String.format("%d years %d months %d days",period.getYears(), period.getMonths(), period.getDays());
	}

}
