package com.possumus.demo.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.Period;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_skill")
@Data
@EqualsAndHashCode(callSuper=true)
public class Skill extends BaseEntity {
	
	private static final long serialVersionUID = 2810534954001205428L;
	
	@ManyToOne()
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	private String technology;
	private Period experience;
}
