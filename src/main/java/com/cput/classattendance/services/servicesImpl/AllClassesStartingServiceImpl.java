/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.services.servicesImpl;

import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.repository.ClassDetailsRepository;
import com.cput.classattendance.services.AllClassesStartingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211064084
 */
@Service
public class AllClassesStartingServiceImpl implements AllClassesStartingService {

    @Autowired
    private ClassDetailsRepository classDetailsRepository;

    @Override
    public List<ClassDetails> getAllClassesStartingAt(String startingTime) {
        List<ClassDetails> classDetails = new ArrayList<>();
        List<ClassDetails> allClassDetails = classDetailsRepository.findAll();// = new ArrayList<>();
        //List<ClassDetails> all 
        for (ClassDetails cd : allClassDetails) {
            if (cd.getStartTime().equals(startingTime)) {
                classDetails.add(cd);
            }
        }

        return classDetails;
    }
//the bottom section you can copy abnd paste from your DAO implmentation classes
    @Override
    public List<ClassDetails> findAll() {
        return classDetailsRepository.findAll();
    }

    @Override
    public ClassDetails find(Long id) {
        return classDetailsRepository.findOne(id);
    }

    @Override
    public ClassDetails persist(ClassDetails entity) {
        return classDetailsRepository.save(entity);
    }

    @Override
    public ClassDetails merge(ClassDetails entity) {
        if (entity.getId() != null) {
            return classDetailsRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(ClassDetails entity) {
        classDetailsRepository.delete(entity);
    }

}
