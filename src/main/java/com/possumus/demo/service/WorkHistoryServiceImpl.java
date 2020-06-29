package com.possumus.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.possumus.demo.endpoints.dto.WorksDto;
import com.possumus.demo.endpoints.mappers.WorkMapper;
import com.possumus.demo.persistence.dao.WorkHistoryDao;
import com.possumus.demo.persistence.entities.Candidate;
import com.possumus.demo.persistence.entities.WorkHistory;
import com.possumus.demo.service.exceptions.WorkNotFoundException;
import com.possumus.demo.service.interfaces.CandidateService;
import com.possumus.demo.service.interfaces.WorkHistoryService;

@Service
@Transactional
public class WorkHistoryServiceImpl implements WorkHistoryService {
	
	@Autowired 
	WorkHistoryDao repository;
	
	@Autowired
	WorkMapper mapper;
	
	@Autowired
	CandidateService serviceCandidate;
	
	@Override
	public List<WorkHistory> getAll(Long idCandidate) {
		return repository.findByCandidateId(idCandidate);
	}

	@Override
	public WorkHistory getById(Long id) {
		return repository.findById(id).orElseThrow(()-> new WorkNotFoundException(id));
	}

	@Override
	public List<WorkHistory> createWorks(WorksDto worksDto) {
		Candidate candidate = serviceCandidate.getById(worksDto.getIdCandidate());	
		List<WorkHistory> works = worksDto.getWorks().stream().map(x -> {WorkHistory work = mapper.dtoToEntity(x);work.setCandidate(candidate); return work;}).collect(Collectors.toList());
		return repository.saveAll(works);
	}

	@Override
	public WorkHistory createOrUpdate(WorkHistory work) {
		work.setCandidate(serviceCandidate.getById(work.getCandidate().getId()));
		return repository.save(work);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
