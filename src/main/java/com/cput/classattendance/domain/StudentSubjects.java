/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<Student> studentID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private List<Subjects> subjectID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id")
    private List<Exams> examID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private List<ClassDetails> classID;

    private StudentSubjects(Builder builder) {
        id = builder.id;
        subjectID = builder.subjectID;
        examID = builder.examID;
        //classID = builder.classID;
        studentID = builder.studentID;
    }

    public static class Builder {

        private Long id;
        private List<Student> studentID;
        private List<Subjects> subjectID;
        private List<Exams> examID;
        private List<Class> classID;

        public Builder(List<Student> studentID) {
            this.studentID = studentID;
        }

        public Builder setId(Long value) {
            id = value;
            return this;
        }

        public Builder SubjectID(List<Subjects> value) {
            subjectID = value;
            return this;
        }

        public Builder ExamID(List<Exams> value) {
            examID = value;
            return this;
        }

        public Builder ClassID(List<Class> value) {
            classID = value;
            return this;
        }

        public Builder StudentSubjects(StudentSubjects studentSubjects) {
            id = studentSubjects.getId();
            studentID = studentSubjects.getStudentID();
            subjectID = studentSubjects.getSubjectID();
            examID = studentSubjects.getExamID();
           // classID = studentSubjects.getClassID();
            return this;

        }

        public StudentSubjects build() {
            return new StudentSubjects(this);
        }

    }

    public Long getId() {
        return id;
    }

    public List<Student> getStudentID() {
        return studentID;
    }

    public List<Subjects> getSubjectID() {
        return subjectID;
    }

    public List<Exams> getExamID() {
        return examID;
    }

    public List<ClassDetails> getClassID() {
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
