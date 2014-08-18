/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.app.conf.ConfConnectionConfig;
import com.cput.classattendance.domain.Student;
import com.cput.classattendance.repository.StudentRepository;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.fail;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aidem
 */
public class StudentRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private StudentRepository repo;
       
    public StudentRepositoryTest() {
    }

     @Test (enabled = true)
     public void createStudent() {
         repo = ctx.getBean(StudentRepository.class);
         Student s = new Student.Builder("211121614")
                 .Name("Aiden")
                 .surname("Page")
                 .Address("any where")
                 .DOB(new Date())
                 .build();

         repo.save(s);
         id = s.getId();
         System.out.println(id);
         Assert.assertNotNull(s); 
     }
     
     @Test(dependsOnMethods = "createStudent", enabled = true)
     public void readStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student student = repo.findOne(id);
         Assert.assertEquals(student.getStudentID(), "211121614");
         
     }
     
    @Test(dependsOnMethods = "readStudent", enabled = true)
     private void updateStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student student = repo.findOne(id);
         Student updatedStudent = new Student.Builder("211121614")
                 .Student(student)
                 .Address("some where else")
                 .build();
        
         repo.save(updatedStudent);
         
         Student newStudent = repo.findOne(id);
         Assert.assertEquals(newStudent.getAddress(), "some where else");
         
     }
     
     @Test(dependsOnMethods = "updateStudent",enabled = true)
     private void deleteStudent(){
         repo = ctx.getBean(StudentRepository.class);
         Student student = repo.findOne(id);
         repo.delete(student);
         
         Student deletedStudent = repo.findOne(id);      
         Assert.assertNull(deletedStudent);
  
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConfConnectionConfig.class);
		
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @BeforeMethod
    public void setUpMethod() {
    }
    
    @AfterMethod
    public void tearDownMethod() {
    }

}
