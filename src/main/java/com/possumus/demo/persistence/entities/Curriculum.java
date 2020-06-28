package com.possumus.demo.persistence.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_curriculum")
@Data
@EqualsAndHashCode(callSuper=true)
public class Curriculum extends BaseEntity {
	
	private static final long serialVersionUID = 7626293502764245167L;
	
	@Lob()
	@Column(name = "base64" ,nullable = true)
	@Basic(optional = false, fetch = FetchType.EAGER)
    private byte[] base64;
	
	@OneToOne(mappedBy="contact")
	private Candidate candidate;
}
