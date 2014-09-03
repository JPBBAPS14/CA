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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Aidem
 */
@Entity
public class StudentSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentID;
    
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subjectsID;
    
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassDetails classID;

    private StudentSubjects(Builder builder) {
        id = builder.id;
        subjectsID = builder.subjectID;
        classID = builder.classID;
        studentID = builder.studentID;
    }
    
    private StudentSubjects() {
    }

    public static class Builder {

        private Long id;
        private Student studentID;
        private Subjects subjectID;
        private ClassDetails classID;

        public Builder() {
        }
        
        public Builder StudentID(Student studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setId(Long value) {
            id = value;
            return this;
        }

        public Builder SubjectID(Subjects value) {
            subjectID = value;
            return this;
        }


        public Builder ClassID(ClassDetails value) {
            classID = value;
            return this;
        }

        public Builder StudentSubjects(StudentSubjects studentSubjects) {
            id = studentSubjects.getId();
            studentID = studentSubjects.getStudentID();
            subjectID = studentSubjects.getSubjectID();
            classID = studentSubjects.getClassID();
            return this;

        }

        public StudentSubjects build() {
            return new StudentSubjects(this);
        }

    }

    public Long getId() {
        return id;
    }
    

    public Student getStudentID() {
        return studentID;
    }

    public Subjects getSubjectID() {
        return subjectsID;
    }

    public ClassDetails getClassID() {
        return classID;
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
        if (!(object instanceof StudentSubjects)) {
            return false;
        }
        StudentSubjects other = (StudentSubjects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.StudentSubjects[ id=" + id + " ]";
    }

}
