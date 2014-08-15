/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 211064084
 */
//DO NOT TOUCH THIS!!!!!!!!!!!
public interface Services <S, ID>{
    public S find(long id);

    public S persist(S entity);

    public S merge(S entity);

    public void remove(S entity);
    
    //CRUD
    /*
    public List<S> getAllRecords();
    
    public S getRecord(long id);
    
    public void updateRecord(S s);
    
    public void deleteRecord(S s);

    public List<S> findAll();
    */
}
