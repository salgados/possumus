package com.possumus.demo.persistence.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_workHistory")
@Data
@EqualsAndHashCode(callSuper=true)
public class WorkHistory extends BaseEntity {
	
	private static final long serialVersionUID = -4603386377003145554L;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	private String company;
	private Date workingFrom;
	private Date workingTo;
}
