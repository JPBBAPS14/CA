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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class Exams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ManyToOne
    //@PrimaryKey
    private String venue;
    private String subject;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    //student subjects embedable? spe;;ing?
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private StudentSubjects studentSubjects;
    

    private Exams(Builder builder) {
        id = builder.id;
        venue = builder.venue;
        subject = builder.subject;
        startTime = builder.startTime;
        endTime = builder.endTime;
        date = builder.date;
        
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
        if (!(object instanceof Exams)) {
            return false;
        }
        Exams other = (Exams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Exams[ id=" + id + " ]";
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StudentSubjects getStudentSubjects() {
        return studentSubjects;
    }

    public static class Builder {

        private Long id;
        //@ManyToOne
        //@PrimaryKey
        private String venue;
        private String subject;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date startTime;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date endTime;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date date;
        
        public Builder(){}
        
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Builder subject(String value) {
            this.subject = value;
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

        public Builder date(Date value) {
            this.date = value;
            return this;
        }
        

        public Builder Exams(Exams value) {
            id = value.getId();
            venue = value.getVenue();
            subject = value.getSubject();
            startTime = value.getStartTime();
            endTime = value.getEndTime();
            date = value.getDate();
            return this;
        }

        public Exams build() {
            return new Exams(this); 
        }

    }

}
