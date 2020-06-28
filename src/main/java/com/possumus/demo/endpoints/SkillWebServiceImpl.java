package com.possumus.demo.endpoints;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.possumus.demo.endpoints.dto.SkillDto;
import com.possumus.demo.endpoints.dto.SkillsDto;
import com.possumus.demo.endpoints.interfaces.SkillWebService;
import com.possumus.demo.endpoints.mappers.SkillMapper;
import com.possumus.demo.persistence.entities.Skill;
import com.possumus.demo.service.interfaces.SkillService;

@RestController()
public class SkillWebServiceImpl implements SkillWebService {
	
	@Autowired
	SkillMapper mapper;
	
	@Autowired
	SkillService service;
	
	@Override
	public ResponseEntity<List<SkillDto>> getAll(Long IdCandidate) {
		return ResponseEntity.ok(mapper.entitiesToDtos(service.getAll(IdCandidate)));
	}

	@Override
	public ResponseEntity<SkillDto> getCandidateSkillById(Long idSkill) {
		return ResponseEntity.ok(mapper.entityToDto(service.getById(idSkill)));
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
	}

	@Override
	public ResponseEntity<List<SkillDto>> createSkills(SkillsDto skillsDto) {
		List<Skill> result = service.createSkills(skillsDto);	
		return ResponseEntity.ok().body(mapper.entitiesToDtos(result));
	}

	@Override
	public ResponseEntity<SkillDto> createOrUpdate(SkillDto skillDto) {
		Skill skill = mapper.dtoToEntity(skillDto);
		Skill result = service.createOrUpdate(skill);
		return ResponseEntity.ok().body(mapper.entityToDto(result));
	}

}
