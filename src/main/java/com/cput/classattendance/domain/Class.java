/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 211064084
 */
@Entity
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    @ManyToOne
    private Lecturer lecturerID;
    
    private Class(Builder builder) {
        id = builder.id;
        startTime = builder.startTime;
        endTime = builder.endTime;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Class[ id=" + id + " ]";
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Lecturer getLecturerID() {
        return lecturerID;
    }
    
     public static class Builder {

        private Long id;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date startTime;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date endTime;
        
        public Builder(){}
        
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder startTime(Date value) {
            this.startTime = value;
            return this;
        }

        public Builder endTime(Date value) {
            this.endTime = value;
            return this;
        }

        public Builder Exams(Exams value) {
            id = value.getId();
            startTime = value.getStartTime();
            endTime = value.getEndTime();
            return this;
        }

        public Class build() {
            return new Class(this); 
        }

    }
    
}
