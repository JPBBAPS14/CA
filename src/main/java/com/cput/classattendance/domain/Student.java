/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Aidem
 */
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String address;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DOB;
    private String StudentID;

    @OneToMany(targetEntity=StudentSubjects.class, mappedBy="studentID", fetch=FetchType.EAGER)
    private List<StudentSubjects> studentSubjects;
    
    private Student(Builder builder) {
    id = builder.id;
    name = builder.name;
    surname = builder.surname;
    address = builder.address;
    DOB = builder.DOB;
    StudentID = builder.StudentID;
       }
    
    private Student() {
       }

   
    
    public static class Builder {

        private Long id;
        private String name;
        private String surname;
        private String address;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date DOB;
        private String StudentID;

        public Builder (String value) {
            this.StudentID = value;
        }
        
        public Builder Name(String value) {
                name = value;
                return this;
            }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder surname(String value) {
            surname = value;
            return this;
        }

        public Builder Address(String value) {
            address = value;
            return this;
        }
        
        public Builder DOB(Date value) {
            DOB = value;
            return this;
        }

       
        public Builder Student(Student student){
            id = student.getId();
            name = student.getName();
            surname = student.getSurname();
            address = student.getAddress();
            DOB = student.getDOB();
            StudentID = student.getStudentID();
            return this;
            
        }
        
        public Student build(){
            return new Student(this);
        }

    }
    public Long getId() {
        return id;
    }

    public String getName() {
            return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getStudentID() {
        return StudentID;
    }
    
    public List<StudentSubjects> getStudentSubjects() {
        return studentSubjects;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Stundents[ id=" + id + " ]";
    }
    
}
