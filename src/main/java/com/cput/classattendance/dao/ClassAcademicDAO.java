/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.ClassAcademic;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author sandisiwe
 */
public interface ClassAcademicDAO extends Services<ClassAcademic, Long>{
    
    public void create();
     
    public List<ClassAcademic> getAllRecords();
    
    public ClassAcademic getRecord(Long id);
    
    public void updateRecord(Long old, ClassAcademic updated);
    
    public void deleteRecord(ClassAcademic d);

    public List<ClassAcademic> findAll();
}
