package com.possumus.demo.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.Interval;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "_workHistory")
@Data
@EqualsAndHashCode(callSuper=true)
public class WorkHistory extends BaseEntity {
	
	private static final long serialVersionUID = -4603386377003145554L;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	private String company;

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentInterval")
    @Columns(columns = { @Column(name="start"),@Column(name="end") })
    public Interval workInterval;
}
