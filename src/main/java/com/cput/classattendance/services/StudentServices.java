/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.services;

import com.cput.classattendance.domain.Student;

/**
 *
 * @author 211121614
 */
public interface StudentServices extends Services<Student, Long>{
     public Student ViewStudAttendance(String Studnum);
     public Student GetStudAcademicYear(String Studnum);
     
}
