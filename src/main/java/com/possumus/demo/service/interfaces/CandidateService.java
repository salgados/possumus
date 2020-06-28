package com.possumus.demo.service.interfaces;

import java.util.List;

import com.possumus.demo.endpoints.dto.CandidateDto;
import com.possumus.demo.persistence.entities.Candidate;

public interface CandidateService {
	List<Candidate> getAll();
	Candidate getById(Long id);
	Candidate createOrUpdate(Candidate candidate);	
	void deleteById(Long id);
}
