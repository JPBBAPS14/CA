/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.AcademicYear;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author sandisiwe
 */
public interface AcademicYearDAO extends Services<AcademicYear, Long>{
    
    public void create();
    
    public List<AcademicYear> getAllRecords();
    
    public AcademicYear getRecord(Long id);
    
    public void updateRecord(Long old, AcademicYear updated);
    
    public void deleteRecord(AcademicYear s);

    public List<AcademicYear> findAll();
}
