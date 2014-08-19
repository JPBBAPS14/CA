/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import com.cput.classattendance.domain.Course;
import com.cput.classattendance.services.Services;
import java.util.List;

/**
 *
 * @author Bradz
 */
public interface CourseDAO extends Services<Course,Long>{
    public void create();
    
    public List<Course> getAllRecords();
    
    public Course getRecord(Long id);
    
    public void updateRecord(Long old, Course updated);
    
    public void deleteRecord(Course s);
    
    public List<Course> findAll();
}
