/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.repository;

import com.cput.classattendance.domain.ClassDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 211064084
 */
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Long>{
    
}
