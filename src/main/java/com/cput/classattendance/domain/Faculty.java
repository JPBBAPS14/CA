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
 * @author 209215178
 */
@Entity
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private int FacultyID;
    private String Name;
    @OneToMany(targetEntity=Department.class, mappedBy="faculty", fetch=FetchType.EAGER)
    private List<Department> department;
    
    private Faculty(Builder builder)
	{
                ID = builder.id;
		FacultyID = builder.facID;
		Name = builder.name;
	}
    
    public static class Builder 
    {
        private Long id;
        private int facID;
        private String name;
        
        public Builder()
        {
           
        }
        
        
        public Builder ID(Long value)
        {
            this.id = value;
            return this;
        }
        
        public Builder FacultyID(int value)
        {
            this.facID = value;
            return this;
        }

        public Builder Name(String value)
        {
            this.name = value;
            return this;
        }
        
        public Builder Faculty(Faculty value)
        {
            id = value.getID();
            facID = value.getFacultyID();
            name = value.getName();
            return this;
        }


        public Faculty build()
        {
            return new Faculty(this);
        }
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
   
    public int getFacultyID()
    {
    	return FacultyID;
    }
    
    public String getName()
    {
    	return Name;
    }
    
    public List<Department> getDepartment() {
        return department;
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
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Faculty[ id=" + ID + " ]";
    }
    
}
