package com.possumus.demo.service.interfaces;

import java.util.List;

import com.possumus.demo.endpoints.dto.SkillsDto;
import com.possumus.demo.persistence.entities.Skill;

public interface SkillService {
	List<Skill> getAll(Long idCandidate);
	Skill getById(Long id);
	List<Skill> createSkills(SkillsDto skillsDto);
	Skill createOrUpdate(Skill skill);
	void deleteById(Long id);
}
