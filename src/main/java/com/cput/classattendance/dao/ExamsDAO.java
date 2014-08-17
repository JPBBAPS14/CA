/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Exams;
import com.cput.classattendance.services.Services;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211064084
 */
@Service
public interface ExamsDAO extends Services<Exams, Long>{
    
    public void create();
    
    public List<Exams> getAllRecords();
    
    public Exams getRecord(Long id);
    
    public void updateRecord(Long old, Exams updated);
    
    public void deleteRecord(Exams s);
    
    public List<Exams> findAll();
}
