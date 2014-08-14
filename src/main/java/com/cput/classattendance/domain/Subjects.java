/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Aidem
 */
@Entity
public class Subjects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String subjectID;
    private String name;
    private String co_ordenator;
    private String courseID;
    
    private Subjects(Builder builder) {
        id = builder.id;
        subjectID = builder.subjectID;
        name = builder.name;
        co_ordenator = builder.co_ordenator;
        courseID = builder.courseID;
       }
    public static class Builder {

        private Long id;
        private String subjectID;
        private String name;
        private String co_ordenator;
        private String courseID;


        public Builder(String value) {
                this.subjectID = value;
            }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder Name(String value) {
            name = value;
            return this;
        }

        public Builder Co_ordenator(String value) {
            co_ordenator = value;
            return this;
        }
        public Builder CourseID(String value) {
            courseID = value;
            return this;
        }
        

       
        public Builder Subjects(Subjects student){
            id = student.getId();
            subjectID = student.getSubjectID();
            name = student.getName();
            co_ordenator = student.getCo_ordenator();
            courseID = student.getCourseID();
            return this;
            
        }
        
        public Subjects build(){
            return new Subjects(this);
        }

    }
    
    
    public Long getId() {
        return id;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public String getName() {
        return name;
    }

    public String getCo_ordenator() {
        return co_ordenator;
    }

    public String getCourseID() {
        return courseID;
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
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Sujects[ id=" + id + " ]";
    }
    
}
