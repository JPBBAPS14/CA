/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.StudentSubjects;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author 211121614
 */
public interface StudentSubjectsDAO extends Services<StudentSubjects, Long>{
    
    public void create(StudentSubjects s);
  
    public List<StudentSubjects> getAllRecords();
    
    public StudentSubjects getRecord(Long id);
    
    public void updateRecord(Long old, StudentSubjects updated);
    
    public void deleteRecord(StudentSubjects s);
    
    public List<StudentSubjects> findAll();
}
