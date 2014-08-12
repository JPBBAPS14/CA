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
 * @author sandisiwe
 */
@Entity
public class ClassAcademic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String academicID;
    private String classID;
    private String vanue;
    
    private ClassAcademic(Builder builder) {
        id = builder.id;
        academicID = builder.academicID;
        classID = builder.classID;
        vanue = builder.vanue;
    }

    private ClassAcademic() {
    }

    public static class Builder {
        
    private Long id;
    private String academicID;
    private String classID;
    private String vanue;
        
    
    public Builder(String academicID) {
            this.academicID = academicID;
        }

    public Builder id(Long value) {
            this.id = value;
            return this;
        } 
    public Builder classID(String value) {
            this.classID = value;
            return this;
        }

    public Builder vanue(String value) {
            this.vanue = value;
            return this;
        }
    
    public Builder ClassAcademic(ClassAcademic value) {
            id = value.getId();
            academicID = value.getAcademicID();
            classID = value.getClassID();
            vanue = value.getVanue();

            return this;
        }

        public ClassAcademic build() {
            return new ClassAcademic(this);
        }
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcademicID() {
        return academicID;
    }

    public void setAcademicID(String academicID) {
        this.academicID = academicID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getVanue() {
        return vanue;
    }

    public void setVanue(String vanue) {
        this.vanue = vanue;
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
        if (!(object instanceof ClassAcademic)) {
            return false;
        }
        ClassAcademic other = (ClassAcademic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sandisiwe.intergratedproject.domain.ClassAcademic[ id=" + id + " ]";
    }
    
}
