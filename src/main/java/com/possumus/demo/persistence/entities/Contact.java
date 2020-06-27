package com.possumus.demo.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "_contact")
public class Contact extends BaseEntity{

	private static final long serialVersionUID = -832260013847239910L;

	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = true, length = 20)
	private String phone;
	
	@OneToOne(mappedBy="contact")
	private Candidate candidate;
}
