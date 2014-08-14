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
 * @author 209215178
 */
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long ID;
    private Long CourseID;
    private String Name;
    private String Type;
    private int Term;
    private int DepartmentID;
    
    private Course(Builder builder)
	{
                ID = builder.id;
		CourseID = builder.courseID;
		Name = builder.name;
		Type = builder.type;
		Term = builder.term;
		DepartmentID = builder.deptID;
	}	

    public Course() 
    {
    }
    
    public static class Builder
    {
        private Long id;
        private Long courseID;
        private String name;
        private String type;
        private int term;
        private int deptID;
        
        public Builder(Long id)
        {
            this.courseID = id;
        }

        public Builder Name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder Type(String value)
        {
            this.type = value;
            return this;
        }

        public Builder Term(int value)
        {
            this.term = value;
            return this;
        }

        public Builder DepartmentID(int value)
        {
            this.deptID = value;
            return this;
        }
        
        public Builder Course(Course value)
        {
            id = value.getId();
            courseID = value.getCourseID();
            name = value.getName();
            type = value.getType();
            term = value.getTerm();
            deptID = value.getDepartmentID();
            return this;
        }

        public Course build()
        {
            return new Course(this);
        }

       
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    } 
        
    public Long getCourseID() {
        return CourseID;
    }

    public void setCourseID(Long CourseID) {
        this.CourseID = CourseID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getTerm() {
        return Term;
    }

    public void setTerm(int Term) {
        this.Term = Term;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CourseID != null ? CourseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.CourseID == null && other.CourseID != null) || (this.CourseID != null && !this.CourseID.equals(other.CourseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cput.classattendance.domain.Course[ id=" + CourseID + " ]";
    }
    
}
