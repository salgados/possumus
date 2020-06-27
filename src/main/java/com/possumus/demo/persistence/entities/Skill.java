package com.possumus.demo.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_skill")
@Data
@EqualsAndHashCode(callSuper=true)
public class Skill extends BaseEntity {
	
	private static final long serialVersionUID = 2810534954001205428L;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	private String technology;
	private Double experience;
}
