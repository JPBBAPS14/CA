/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.FacultyDAO;
import com.cput.classattendance.domain.Faculty;
import com.cput.classattendance.repository.FacultyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bradz
 */
@Service
public class FacultyDAOImpl implements FacultyDAO {

    @Autowired
    private FacultyRepository facultyRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Faculty> getAllRecords() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getRecord(Long id) {
        return facultyRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Faculty updated) {
        id = old;
        facultyRepository = ctx.getBean(FacultyRepository.class);
        Faculty eOld = facultyRepository.findOne(old);
        Faculty updatedFaculty = updated;
        eOld = updated;
        facultyRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Faculty s) {
        facultyRepository.delete(s);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty find(Long id) {
        return facultyRepository.findOne(id);
    }

    @Override
    public Faculty persist(Faculty entity) {
        return facultyRepository.save(entity);
    }

    @Override
    public Faculty merge(Faculty entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Faculty entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
    
    }
    
}
