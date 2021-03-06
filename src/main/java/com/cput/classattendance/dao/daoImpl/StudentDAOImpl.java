/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.StudentDAO;
import com.cput.classattendance.domain.Student;
import com.cput.classattendance.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Aidem
 */
public class StudentDAOImpl implements StudentDAO {
    
    @Autowired
    private StudentRepository studentRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Student> getAllRecords() {
        return studentRepository.findAll();
    }

    @Override
    public Student getRecord(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Student updated) {
        id = old;
        studentRepository = ctx.getBean(StudentRepository.class);
        Student eOld = studentRepository.findOne(old);
        Student updatedExam = updated;
        eOld = updated;
        studentRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Student s) {
        studentRepository.delete(s);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student find(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Student persist(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public Student merge(Student entity) {
        if (entity.getId() != null) {
            return studentRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Student entity) {
        studentRepository.delete(entity);
    }

    @Override
    public void create(Student s) {

    }
}
