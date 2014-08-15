/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Exams;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author 211064084
 */
public interface ExamsDAO extends Services{
    public List<Exams> getAllRecords();
    
    public Exams getRecord(long id);
    
    public void updateRecord(Exams s);
    
    public void deleteRecord(Exams s);

    public List<Exams> findAll();
}
