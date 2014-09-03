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
 * @author 209215178
 */
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private int DepartmentID;
    private String Name;    
    @ManyToOne
    @JoinColumn(name = "Faculty_ID")
    private Faculty faculty;
    private int FacultyID;
    
    private Department(Builder builder)
    {
        ID = builder.id;
	DepartmentID = builder.deptID;
	Name = builder.name;	
	FacultyID = builder.facID;
    }
    
    private Department()
    {
    }
    
    public static class Builder
    {
        private Long id;
        private int deptID;
        private String name;      
        private int facID;
        
        public Builder()
        {
                        
        }
        
        public Builder deptID(int value)
        {
            this.deptID = value;
            return this;
        }
        
        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        
        public Builder name(String value)
        {
            this.name = value;
            return this;
        }
        
        
        public Builder facID(int value)
        {
            this.facID = value;
            return this;
        }
        
        public Builder Department(Department value)
        {
            id = value.getID();
            deptID = value.getDepartmentID();
            name = value.getName();
            facID = value.getFacultyID();
            return this;
        }
        
        public Department build()
        {
            return new Department(this);
        }

        
    }
	

      public Long getID() {
        return ID;
    }

    public Faculty getFaculty() {
        return faculty;
    }
    
    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(int FacultyID) {
        this.FacultyID = FacultyID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Department[ id=" + ID + " ]";
    }
    
}
