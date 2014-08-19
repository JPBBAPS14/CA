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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sandisiwe
 */
@Entity
public class AcademicYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String academicID;
    
   @ManyToOne
   @JoinColumn(name = "academic_ID")
    private ClassAcademic classAcademic;
    
     private AcademicYear(Builder builder) {
        id = builder.id;
        academicID = builder.academicID;
         this.classAcademic = builder.classAcademic; 
        
    }
     
    private AcademicYear() {
    }
 
    public static class Builder {
        
        private Long id;
        private String academicID;
        private ClassAcademic classAcademic;
        
         public Builder(String academicID) {
            this.academicID = academicID;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
            
        
        }
        
        public Builder ClassAcademics(ClassAcademic classAcademic) {
            this.classAcademic = classAcademic;
            return this;
        }
        
        
        public Builder AcademicYear(AcademicYear value) {
            id = value.getId();
            academicID = value.getAcademicID();
            this.classAcademic = value.getClassAcademic();
         return this;   
        }

        public AcademicYear build() {
            return new AcademicYear(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getAcademicID() {
        return academicID;
    }

    public ClassAcademic getClassAcademic() {
        return classAcademic;
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
        if (!(object instanceof AcademicYear)) {
            return false;
        }
        AcademicYear other = (AcademicYear) object;
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
