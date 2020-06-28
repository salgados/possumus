package com.possumus.demo.endpoints;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.possumus.demo.endpoints.dto.CandidateDto;
import com.possumus.demo.endpoints.interfaces.CandidateWebService;
import com.possumus.demo.endpoints.mappers.CandidateMapper;
import com.possumus.demo.persistence.entities.Candidate;
import com.possumus.demo.service.interfaces.CandidateService;

@RestController()
public class CandidateWebServiceImpl implements CandidateWebService {
	
	@Autowired
	CandidateService service;
	
	@Autowired
	CandidateMapper mapper;
	
	
	@Override
	public ResponseEntity<List<CandidateDto>> getAll() {
		return ResponseEntity.ok().body(mapper.entitiesToDtos(service.getAll()));
	}

	@Override
	public ResponseEntity<CandidateDto> getById(Long id) {
		return ResponseEntity.ok().body(mapper.entityToDto(service.getById(id)));
	}

	@Override
	public ResponseEntity<CandidateDto> createOrUpdate(CandidateDto candidateDto) {
		Candidate candidate = mapper.dtoToEntity(candidateDto);
		Candidate result =  service.createOrUpdate(candidate);
		return ResponseEntity.ok().body(mapper.entityToDto(result));
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
	}

}
