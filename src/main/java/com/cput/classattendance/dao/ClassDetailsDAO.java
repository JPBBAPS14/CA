/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.domain.Exams;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface ClassDetailsDAO extends Services<ClassDetails, Long>{
    
    public void create(ClassDetails s);
    
    public List<ClassDetails> getAllRecords();
    
    public ClassDetails getRecord(Long id);
    
    public void updateRecord(Long old, ClassDetails updated);
    
    public void deleteRecord(ClassDetails s);
    
    public List<ClassDetails> findAll();
    
}
