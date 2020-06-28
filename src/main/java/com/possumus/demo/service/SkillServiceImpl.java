package com.possumus.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.possumus.demo.endpoints.dto.SkillsDto;
import com.possumus.demo.endpoints.mappers.SkillMapper;
import com.possumus.demo.persistence.dao.SkillDao;
import com.possumus.demo.persistence.entities.Candidate;
import com.possumus.demo.persistence.entities.Skill;
import com.possumus.demo.service.exceptions.SkillNotFoundException;
import com.possumus.demo.service.interfaces.CandidateService;
import com.possumus.demo.service.interfaces.SkillService;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	SkillDao repository;
	
	@Autowired
	CandidateService serviceCandidate;
	
	@Autowired
	SkillMapper mapper;
	
	@Override
	public List<Skill> getAll(Long idCandidate) {
		return repository.findByCandidateId(idCandidate);
	}

	@Override
	public Skill getById(Long id) {
		return repository.findById(id).orElseThrow(()-> new SkillNotFoundException(id));
	}

	@Override
	public Skill createOrUpdate(Skill skill) {
		return repository.save(skill);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Skill> createSkills(SkillsDto skillsDto) {
		Candidate candidate = serviceCandidate.getById(skillsDto.getIdCandidate());	
		List<Skill> skills = skillsDto.getSkills().stream().map(x -> {Skill skill = mapper.dtoToEntity(x);skill.setCandidate(candidate); return skill;}).collect(Collectors.toList());
		return repository.saveAll(skills);
	}

}
