/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.ExamsDAO;
import com.cput.classattendance.domain.Exams;
import com.cput.classattendance.repository.ExamsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211064084
 */

@Service //if it doesnt work without @service then uncomment it ok
public class ExamDAOImpl implements ExamsDAO{
    
    @Autowired
    private ExamsRepository examsRepository;
    
    public static ApplicationContext ctx;
    private Long id;
    
    @Override
    public List<Exams> getAllRecords() {
        return examsRepository.findAll();
    }

    @Override
    public Exams getRecord(Long id) {
        return examsRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Exams updated) {
        //id = old;
        examsRepository = ctx.getBean(ExamsRepository.class);
        Exams eOld = examsRepository.findOne(old);
        //Exams updatedExam = updated;
        eOld = updated;
        examsRepository.save(eOld);

    }

    @Override
    public void deleteRecord(Exams s) {
        examsRepository.delete(s);
    }

    @Override
    public List<Exams> findAll() {
        return examsRepository.findAll();
    }

    @Override
    public Exams find(Long id) {
        return examsRepository.findOne(id);
    }

    @Override
    public Exams persist(Exams entity) {
        return examsRepository.save(entity);
        }

    @Override
    public Exams merge(Exams entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Exams entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
}
