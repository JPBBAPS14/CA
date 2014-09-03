/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.StudentSubjectsDAO;
import com.cput.classattendance.domain.StudentSubjects;
import com.cput.classattendance.repository.StudentSubjectsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author 211121614
 */
public class StudentSubjectsDAOImpl implements StudentSubjectsDAO{
        @Autowired
    private StudentSubjectsRepository studentSubjectsRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<StudentSubjects> getAllRecords() {
        return studentSubjectsRepository.findAll();
    }

    @Override
    public StudentSubjects getRecord(Long id) {
        return studentSubjectsRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, StudentSubjects updated) {
        id = old;
        studentSubjectsRepository = ctx.getBean(StudentSubjectsRepository.class);
        StudentSubjects eOld = studentSubjectsRepository.findOne(old);
        StudentSubjects updatedExam = updated;
        eOld = updated;
        studentSubjectsRepository.save(eOld);
    }

    @Override
    public void deleteRecord(StudentSubjects s) {
        studentSubjectsRepository.delete(s);
    }

    @Override
    public List<StudentSubjects> findAll() {
        return studentSubjectsRepository.findAll();
    }

    @Override
    public StudentSubjects find(Long id) {
        return studentSubjectsRepository.findOne(id);
    }

    @Override
    public StudentSubjects persist(StudentSubjects entity) {
        return studentSubjectsRepository.save(entity);
    }

    @Override
    public StudentSubjects merge(StudentSubjects entity) {
        if (entity.getId() != null) {
            return studentSubjectsRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(StudentSubjects entity) {
        studentSubjectsRepository.delete(entity);
    }

    @Override
    public void create(StudentSubjects s) {

    }
}
