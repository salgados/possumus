package com.possumus.demo.endpoints.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.possumus.demo.endpoints.dto.SkillDto;
import com.possumus.demo.endpoints.dto.SkillsDto;

@RequestMapping("/skill")
public interface SkillWebService {
	
	@GetMapping("/candidate/{idCandidate}")
	ResponseEntity<List<SkillDto>> getAll(@PathVariable("idCandidate") Long IdCandidate);
	
	@GetMapping("/{idSkill}")
	ResponseEntity<SkillDto> getCandidateSkillById(@PathVariable("idSkill") Long IdSkill);
	
	@PostMapping("/list")
	ResponseEntity<List<SkillDto>> createSkills(@RequestBody SkillsDto skills);
	
	@PostMapping("/")
	@PutMapping("/")
	ResponseEntity<SkillDto> createOrUpdate(@RequestBody SkillDto skill);
	
	@DeleteMapping("/{idSkill}")
	void deleteById(@PathVariable("idSkill") Long Id);
}
