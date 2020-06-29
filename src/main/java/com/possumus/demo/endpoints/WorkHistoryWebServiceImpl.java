package com.possumus.demo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.possumus.demo.endpoints.dto.WorkDto;
import com.possumus.demo.endpoints.dto.WorksDto;
import com.possumus.demo.endpoints.interfaces.WorkHistoryWebService;
import com.possumus.demo.endpoints.mappers.WorkMapper;
import com.possumus.demo.persistence.entities.WorkHistory;
import com.possumus.demo.service.interfaces.WorkHistoryService;

@RestController
public class WorkHistoryWebServiceImpl implements WorkHistoryWebService {

	@Autowired
	WorkMapper mapper;
	
	@Autowired
	WorkHistoryService service;
	
	@Override
	public ResponseEntity<List<WorkDto>> getAllCandidateWorks(Long id) {
		return ResponseEntity.ok(mapper.entitiesToDtos(service.getAll(id)));
	}

	@Override
	public ResponseEntity<WorkDto> getCandidateWorkById(Long id) {
		return ResponseEntity.ok(mapper.entityToDto(service.getById(id)));
	}

	@Override
	public ResponseEntity<List<WorkDto>> createWorks(WorksDto worksDto) {
		List<WorkHistory> result = service.createWorks(worksDto);	
		return ResponseEntity.ok().body(mapper.entitiesToDtos(result));
	}

	@Override
	public ResponseEntity<WorkDto> createOrUpdate(WorkDto workDto) {
		WorkHistory work = mapper.dtoToEntity(workDto);
		WorkHistory result = service.createOrUpdate(work);
		return ResponseEntity.ok().body(mapper.entityToDto(result));
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
	}

}
