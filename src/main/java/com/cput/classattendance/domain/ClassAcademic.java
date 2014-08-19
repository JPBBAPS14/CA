/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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
    @OneToMany(targetEntity=AcademicYear.class, mappedBy="classAcademic", fetch=FetchType.EAGER)
    private List<AcademicYear> academicYear;
    
   @OneToMany(targetEntity=ClassDetails.class, mappedBy="classAcademic", fetch=FetchType.EAGER)
    private List<ClassDetails> classDetails;
    
    private ClassAcademic(Builder builder) {
        this.id = builder.id;
        this.academicID = builder.academicID;
        this.classID = builder.classID;
        this.vanue = builder.vanue;
        this.academicYear = builder.academicYear;
        this.classDetails = builder.classDetails;
    }

    private ClassAcademic() {
    }

    public static class Builder {
        
    private Long id;
    private String academicID;
    private String classID;
    private String vanue;
    private List<AcademicYear> academicYear;
    private List<ClassDetails> classDetails;
    
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
    
     public Builder AcademicYears(List<AcademicYear> academicYear) {
            this.academicYear = academicYear;
            return this;
        }
     
      public Builder Classes(List<ClassDetails> classDetails) {
            this.classDetails = classDetails;
            return this;
        }
    
    public Builder ClassAcademic(ClassAcademic value) {
            id = value.getId();
            academicID = value.getAcademicID();
            classID = value.getClassID();
            vanue = value.getVanue();
            academicYear = value.getYear();
            classDetails = value.getClasses();

            return this;
        }

        public ClassAcademic build() {
            return new ClassAcademic(this);
        }
        
    }
    
    public Long getId() {
        return id;
    }

    public String getAcademicID() {
        return academicID;
    }

    public String getClassID() {
        return classID;
    }

    public String getVanue() {
        return vanue;
    }

    public List<AcademicYear> getYear() {
        return academicYear;
    }


    public List<ClassDetails> getClasses() {
        return classDetails;
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
        return "com.cput.classattendance.domain.Class[ id=" + id + " ]";
    }
    
}
