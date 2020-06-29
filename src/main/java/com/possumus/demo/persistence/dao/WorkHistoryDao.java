package com.possumus.demo.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possumus.demo.persistence.entities.WorkHistory;

public interface WorkHistoryDao extends JpaRepository<WorkHistory, Long>{
	List<WorkHistory> findByCandidateId(Long id);
}
