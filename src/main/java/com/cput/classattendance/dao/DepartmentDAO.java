/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Department;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author Bradz
 */
public interface DepartmentDAO extends Services<Department,Long>{
    public void create();
    
    public List<Department> getAllRecords();
    
    public Department getRecord(Long id);
    
    public void updateRecord(Long old, Department updated);
    
    public void deleteRecord(Department s);
    
    public List<Department> findAll();
    
}
