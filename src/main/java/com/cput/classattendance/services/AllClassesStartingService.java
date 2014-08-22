/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.services;

import com.cput.classattendance.domain.ClassDetails;
import java.util.List;

/**
 *
 * @author 211064084
 */
public interface AllClassesStartingService extends Services<ClassDetails, Long> {
    public List<ClassDetails> getAllClassesStartingAt(String s);
}
