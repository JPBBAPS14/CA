/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Faculty;
import com.cput.classattendance.services.Services;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bradz
 */
@Service
public interface FacultyDAO extends Services<Faculty,Long>{
    public void create();
    
    public List<Faculty> getAllRecords();
    
    public Faculty getRecord(Long id);
    
    public void updateRecord(Long old, Faculty updated);
    
    public void deleteRecord(Faculty s);
    
    public List<Faculty> findAll();
}
