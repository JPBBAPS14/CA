/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.ClassAcademicDAO;
import com.cput.classattendance.domain.ClassAcademic;
import com.cput.classattendance.repository.ClassAcademicRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sandisiwe
 */
@Repository("ClassAcademic")

public abstract class ClassAcademicDAOImpl implements ClassAcademicDAO{

    @Autowired
    private ClassAcademicRepository classAcademicRepository;
    
     public static ApplicationContext ctx;
     private Long id;
     
     
    @Override
    public List<ClassAcademic> getAllRecords() {
    return classAcademicRepository.findAll();
    }
    
    @Override
    public ClassAcademic getRecord(Long id) {
    return classAcademicRepository.findOne(id);
    }
    
    @Override
    public void updateRecord(Long old, ClassAcademic updated) {
    id = old;
    classAcademicRepository = ctx.getBean(ClassAcademicRepository.class);
    ClassAcademic eOld = classAcademicRepository.findOne(old);
    ClassAcademic updatedClassAcademic = updated;
    eOld = updated;
    classAcademicRepository.save(eOld);
    }
    @Override
    public void deleteRecord(ClassAcademic s) {
    classAcademicRepository.delete(s);
    }
    @Override
    public List<ClassAcademic> findAll() {
    return classAcademicRepository.findAll();
    }
    
    @Override
    public ClassAcademic persist(ClassAcademic entity) {
    return classAcademicRepository.save(entity);
    }
    @Override
    public ClassAcademic merge(ClassAcademic entity) {
    if (entity.getId() != null) {
    return classAcademicRepository.save(entity);
    }
    return null;
    }
    @Override
    public void remove(ClassAcademic entity) {
    classAcademicRepository.delete(entity);
    }
    @Override
    public void create() {
    }

    
}
