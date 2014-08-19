/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.LecturerDAO;
import com.cput.classattendance.domain.Lecturer;
import com.cput.classattendance.repository.LecturerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jean-Paul
 */
@Service
public class LecturerDAOImpl implements LecturerDAO {
    
    @Autowired
    private LecturerRepository lecturerRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Lecturer> getAllRecords() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer getRecord(Long id) {
        return lecturerRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Lecturer updated) {
        id = old;
        lecturerRepository = ctx.getBean(LecturerRepository.class);
        Lecturer eOld = lecturerRepository.findOne(old);
        Lecturer updatedExam = updated;
        eOld = updated;
        lecturerRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Lecturer s) {
        lecturerRepository.delete(s);
    }

    @Override
    public List<Lecturer> findAll() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer find(Long id) {
        return lecturerRepository.findOne(id);
    }

    @Override
    public Lecturer persist(Lecturer entity) {
        return lecturerRepository.save(entity);
    }

    @Override
    public Lecturer merge(Lecturer entity) {
        if (entity.getId() != null) {
            return lecturerRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Lecturer entity) {
        lecturerRepository.delete(entity);
    }

    @Override
    public void create(Lecturer s) {

    }
    
}
