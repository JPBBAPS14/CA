/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Lecturer;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface LecturerDAO extends Services<Lecturer, Long>{
    public void create(Lecturer s);
    
    public List<Lecturer> getAllRecords();
    
    public Lecturer getRecord(Long id);
    
    public void updateRecord(Long old, Lecturer updated);
    
    public void deleteRecord(Lecturer s);
    
    public List<Lecturer> findAll();
}
