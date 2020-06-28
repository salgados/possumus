package com.possumus.demo.persistence.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "_candidate")
public class Candidate extends BaseEntity {
	
	private static final long serialVersionUID = 4358729734362176191L;

	@Column(nullable = false, length = 50)
	private String firstname;
	
	@Column(nullable = false, length = 50)
	private String lastname;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private java.util.Date birthdate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
	private Contact contact;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curriculum_id", referencedColumnName = "id")
	private Curriculum curriculum;
	
	@OneToMany(mappedBy="candidate")
	private List<Skill> skill;
	
	@OneToMany(mappedBy="candidate")
	private List<WorkHistory> workHistory;
}
