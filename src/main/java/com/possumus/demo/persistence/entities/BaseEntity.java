package com.possumus.demo.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 3129109928248939158L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
    private Date creationTimestamp;
    

    @UpdateTimestamp
    private Date modificationTimestamp;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Date getModificationTimestamp() {
        return modificationTimestamp;
    }


    public void setModificationTimestamp(Date modificationTimestamp) {
        this.modificationTimestamp = modificationTimestamp;
    }


    public Date getCreationTimestamp() {
        return creationTimestamp;
    }


    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
    
    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (this.getClass() != other.getClass()) {
            return false;
        }

        BaseEntity persistentObject = (BaseEntity) other;
        return getId() != null && getId().equals(persistentObject.getId());

    }


    @Override
    public int hashCode() {

        if (getId() != null) {
            return this.getClass().hashCode() + getId().hashCode();
        } else {
            return super.hashCode();
        }
    }
}