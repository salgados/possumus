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

import com.possumus.demo.endpoints.dto.WorkDto;
import com.possumus.demo.endpoints.dto.WorksDto;

@RequestMapping("/workhistory")
public interface WorkHistoryWebService {
	
	@GetMapping("/candidate/{id}")
	ResponseEntity<List<WorkDto>> getAllCandidateWorks(@PathVariable("id") Long id);
	
	@GetMapping("/{id}")
	ResponseEntity<WorkDto> getCandidateWorkById(@PathVariable("id") Long id);
	
	@PostMapping("/list")
	ResponseEntity<List<WorkDto>> createWorks(@RequestBody WorksDto works);
	
	@PostMapping("/")
	@PutMapping("/")
	ResponseEntity<WorkDto> createOrUpdate(@RequestBody WorkDto work);
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") Long Id);
}