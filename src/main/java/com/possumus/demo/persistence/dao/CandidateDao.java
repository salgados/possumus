package com.possumus.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possumus.demo.persistence.entities.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Long>{

}
