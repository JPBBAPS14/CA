/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.CourseDAO;
import com.cput.classattendance.domain.Course;
import com.cput.classattendance.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Bradz
 */
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private CourseRepository courseRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Course> getAllRecords() {
        return courseRepository.findAll();
    }

    @Override
    public Course getRecord(Long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Course updated) {
        id = old;
        courseRepository = ctx.getBean(CourseRepository.class);
        Course eOld = courseRepository.findOne(old);
        Course updatedCourse = updated;
        eOld = updated;
        courseRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Course s) {
        courseRepository.delete(s);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course find(Long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course persist(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public Course merge(Course entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Course entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
    
    }
    
}
