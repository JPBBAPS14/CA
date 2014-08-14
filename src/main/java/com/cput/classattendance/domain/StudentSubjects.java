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
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<Student> studentID;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private List<Subjects> subjectID;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_id")
    private List<Exams> examID;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private List<ClassDetails> classID;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubjectID(List<Subjects> subjectID) {
        this.subjectID = subjectID;
    }

    public void setStudentID(List<Student> studentID) {
        this.studentID = studentID;
    }

    public void setExamID(List<Exams> examID) {
        this.examID = examID;
    }
    
    public void setClassID(List<ClassDetails> classID) {
        this.classID = classID;
    }
    
    public Long getId() {
        return id;
    }
    
    public List<Subjects> getSubjectID() {
        return subjectID;
    }
    
    public List<Student> getStudentID() {
        return studentID;
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
