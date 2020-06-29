package com.possumus.demo.persistence.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_workHistory")
@Data
@EqualsAndHashCode(callSuper=true)
public class WorkHistory extends BaseEntity {
	
	private static final long serialVersionUID = -4603386377003145554L;
	
	@ManyToOne()
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	private String company;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date endDate;
}
