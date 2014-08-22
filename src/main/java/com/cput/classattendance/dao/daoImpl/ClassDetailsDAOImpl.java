/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.ClassDetailsDAO;
import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.repository.ClassDetailsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jean-Paul
 */
@Service 
public class ClassDetailsDAOImpl implements ClassDetailsDAO{
    
    @Autowired
    private ClassDetailsRepository classDetailsRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<ClassDetails> getAllRecords() {
        return classDetailsRepository.findAll();
    }

    @Override
    public ClassDetails getRecord(Long id) {
        return classDetailsRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, ClassDetails updated) {
        id = old;
       
        ClassDetails eOld = classDetailsRepository.findOne(id);       
        eOld = updated;
        classDetailsRepository.save(eOld);
    }

    @Override
    public void deleteRecord(ClassDetails s) {
        classDetailsRepository.delete(s);
    }

    @Override
    public List<ClassDetails> findAll() {
        return classDetailsRepository.findAll();
    }

    @Override
    public ClassDetails find(Long id) {
        return classDetailsRepository.findOne(id);
    }

    @Override
    public ClassDetails persist(ClassDetails entity) {
        return classDetailsRepository.save(entity);
    }

    @Override
    public ClassDetails merge(ClassDetails entity) {
        if (entity.getId() != null) {
            return classDetailsRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(ClassDetails entity) {
        classDetailsRepository.delete(entity);
    }

    @Override
    public void create(ClassDetails s) {
        classDetailsRepository.save(s);
    }
    
}
