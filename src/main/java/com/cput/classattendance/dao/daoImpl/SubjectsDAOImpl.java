/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.SubjectsDAO;
import com.cput.classattendance.domain.Subjects;
import com.cput.classattendance.repository.SubjectsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Aidem
 */
public class SubjectsDAOImpl implements SubjectsDAO {
    @Autowired
    private SubjectsRepository studentRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Subjects> getAllRecords() {
        return studentRepository.findAll();
    }

    @Override
    public Subjects getRecord(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Subjects updated) {
        id = old;
        studentRepository = ctx.getBean(SubjectsRepository.class);
        Subjects eOld = studentRepository.findOne(old);
        Subjects updatedExam = updated;
        eOld = updated;
        studentRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Subjects s) {
        studentRepository.delete(s);
    }

    @Override
    public List<Subjects> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Subjects find(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Subjects persist(Subjects entity) {
        return studentRepository.save(entity);
    }

    @Override
    public Subjects merge(Subjects entity) {
        if (entity.getId() != null) {
            return studentRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Subjects entity) {
        studentRepository.delete(entity);
    }

    @Override
    public void create(Subjects s) {

    }
}
