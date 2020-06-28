package com.possumus.demo.endpoints.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.possumus.demo.endpoints.dto.CandidateDto;

@RequestMapping("/candidate")
public interface CandidateWebService {

	@GetMapping("/")
	ResponseEntity<List<CandidateDto>> getAll();
	
	@GetMapping("/{id}")
	ResponseEntity<CandidateDto> getById(@PathVariable Long id);
	
	@PostMapping("/")
	ResponseEntity<CandidateDto> createOrUpdate(@RequestBody CandidateDto candidate);
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable Long id);
	
}
