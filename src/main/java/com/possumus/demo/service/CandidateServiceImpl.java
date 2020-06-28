package com.possumus.demo.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.possumus.demo.endpoints.mappers.CandidateMapper;
import com.possumus.demo.persistence.dao.CandidateDao;
import com.possumus.demo.persistence.entities.Candidate;
import com.possumus.demo.service.exceptions.CandidateNotFoundException;
import com.possumus.demo.service.interfaces.CandidateService;

@Service()
@Transactional()
public class CandidateServiceImpl implements CandidateService {

	@Autowired 
	CandidateDao repository;
	
	@Override
	public List<Candidate> getAll() {
		return repository.findAll();
	}

	@Override
	public Candidate getById(Long id){
		return repository.findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
	}

	@Override
	public Candidate createOrUpdate(Candidate candidate) {
		return repository.save(candidate);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
