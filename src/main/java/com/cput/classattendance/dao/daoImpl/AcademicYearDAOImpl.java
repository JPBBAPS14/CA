/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.AcademicYearDAO;
import com.cput.classattendance.domain.AcademicYear;
import com.cput.classattendance.repository.AcademicYearRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author sandisiwe
 */

public abstract class AcademicYearDAOImpl implements AcademicYearDAO{
    
    @Autowired
    private AcademicYearRepository academicYearRepository;

     public static ApplicationContext ctx;
     private Long id;
     
     
    @Override
    public List<AcademicYear> getAllRecords() {
    return academicYearRepository.findAll();
    }
    
    @Override
    public AcademicYear getRecord(Long id) {
    return academicYearRepository.findOne(id);
    }
    
    @Override
    public void updateRecord(Long old, AcademicYear updated) {
    id = old;
    academicYearRepository = ctx.getBean(AcademicYearRepository.class);
    AcademicYear eOld = academicYearRepository.findOne(old);
    AcademicYear updatedAcademicYear = updated;
    eOld = updated;
    academicYearRepository.save(eOld);
    }
    @Override
    public void deleteRecord(AcademicYear s) {
    academicYearRepository.delete(s);
    }
    @Override
    public List<AcademicYear> findAll() {
    return academicYearRepository.findAll();
    }
    
    @Override
    public AcademicYear persist(AcademicYear entity) {
    return academicYearRepository.save(entity);
    }
    @Override
    public AcademicYear merge(AcademicYear entity) {
    if (entity.getId() != null) {
    return academicYearRepository.save(entity);
    }
    return null;
    }
    @Override
    public void remove(AcademicYear entity) {
    academicYearRepository.delete(entity);
    }
    @Override
    public void create() {
    }

    
}
