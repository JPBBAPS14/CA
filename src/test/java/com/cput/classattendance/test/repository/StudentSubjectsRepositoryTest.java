/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.Student;
import com.cput.classattendance.domain.StudentSubjects;
import com.cput.classattendance.repository.StudentRepository;
import com.cput.classattendance.repository.StudentSubjectsRepository;
import com.cput.classattendance.test.ConnectionConfigTest;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;

/**
 *
 * @author Aidem
 */
public class StudentSubjectsRepositoryTest {
    
    
     public static ApplicationContext ctx;
    private Long id;
    
    private StudentSubjectsRepository repo;
       
    public StudentSubjectsRepositoryTest() {
    }

     @org.testng.annotations.Test (enabled = true)
     public void createStudent() {
//         repo = ctx.getBean(StudentSubjectsRepository.class);
//         StudentSubjects s = new StudentSubjects.Builder("211121614")
//                 
//                 .build();
//
//         repo.save(s);
//         id = s.getId();
//         Assert.assertNotNull(s); 
     }
     
     @org.testng.annotations.Test(dependsOnMethods = "createStudent", enabled = true)
     public void readStudent(){
         repo = ctx.getBean(StudentSubjectsRepository.class);
         StudentSubjects studentSubjects = repo.findOne(id);
         Assert.assertEquals(studentSubjects.getStudentID(), "211121614");
         
     }
     
    @org.testng.annotations.Test(dependsOnMethods = "readStudent", enabled = true)
     private void updateStudent(){
//         repo = ctx.getBean(StudentSubjectsRepository.class);
//         StudentSubjects studentSubjects = repo.findOne(id);
//         StudentSubjects updatedStudentSubjects = new StudentSubjects.Builder("211121614")
//                 .Student(studentSubjects)
//                 .Address("some where else")
//                 .build();
//        
//         repo.save(updatedStudentSubjects);
//         
//         StudentSubjects newStudentSubjects = repo.findOne(id);
//         Assert.assertEquals(newStudentSubjects.getAddress(), "some where else");
         
     }
     
     @org.testng.annotations.Test(dependsOnMethods = "updateStudent",enabled = true)
     private void deleteStudent(){
         repo = ctx.getBean(StudentSubjectsRepository.class);
         StudentSubjects studentSubjects = repo.findOne(id);
         repo.delete(studentSubjects);
         
         StudentSubjects deletedStudent = repo.findOne(id);      
         Assert.assertNull(deletedStudent);
  
     }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
        	 ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
		
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
