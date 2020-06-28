package com.possumus.demo.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possumus.demo.persistence.entities.Skill;

public interface SkillDao extends JpaRepository<Skill, Long>{
	List<Skill> findByCandidateId(Long id); 
}
