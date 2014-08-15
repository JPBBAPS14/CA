/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.dao;

import java.io.Serializable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 211064084
 */
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class HibernateDao {
    
}
