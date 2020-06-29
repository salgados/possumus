package com.possumus.demo.service.interfaces;

import java.util.List;

import com.possumus.demo.endpoints.dto.WorksDto;
import com.possumus.demo.persistence.entities.Skill;
import com.possumus.demo.persistence.entities.WorkHistory;

public interface WorkHistoryService {
	List<WorkHistory> getAll(Long idCandidate);
	WorkHistory getById(Long id);
	List<WorkHistory> createWorks(WorksDto worksDto);
	WorkHistory createOrUpdate(WorkHistory work);
	void deleteById(Long id);
}
