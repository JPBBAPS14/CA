/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Student;
import com.cput.classattendance.services.Services;
import java.util.List;
/**
 *
 * @author 211121614
 */
public interface StudentDAO extends Services<Student, Long>{
    
    public void create(Student s);
  
    public List<Student> getAllRecords();
    
    public Student getRecord(Long id);
    
    public void updateRecord(Long old, Student updated);
    
    public void deleteRecord(Student s);
    
    public List<Student> findAll();
}
