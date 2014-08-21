/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Subjects;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author 211121614
 */
public interface SubjectsDAO extends Services<Subjects, Long>{
    
    public void create(Subjects s);
  
    public List<Subjects> getAllRecords();
    
    public Subjects getRecord(Long id);
    
    public void updateRecord(Long old, Subjects updated);
    
    public void deleteRecord(Subjects s);
    
    public List<Subjects> findAll();
    
}
