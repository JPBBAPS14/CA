/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.Subjects;
import com.cput.classattendance.repository.SubjectsRepository;
import com.cput.classattendance.test.ConnectionConfigTest;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Aidem
 */
public class SubjectsRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private SubjectsRepository repo;
       
    public SubjectsRepositoryTest() {
    }

     @Test (enabled = true)
     public void createSubjects() {
         repo = ctx.getBean(SubjectsRepository.class);
         Subjects s = new Subjects.Builder("DOS300S")
                 .CourseID("1")
                 .Co_ordenator("Mrs G Khan")
                 .Name("DEVLELOPMENT SOFTWARE 3")
                 .build();

         repo.save(s);
         id = s.getId();
         Assert.assertNotNull(s); 
     }
     
     @Test(dependsOnMethods = "createSubjects", enabled = true)
     public void readSubjects(){
         repo = ctx.getBean(SubjectsRepository.class);
         Subjects subjects = repo.findOne(id);
         Assert.assertEquals(subjects.getSubjectID(), "DOS300S");
         
     }
     
    @Test(dependsOnMethods = "readSubjects", enabled = true)
     private void updateSubjects(){
         repo = ctx.getBean(SubjectsRepository.class);
         Subjects subjects = repo.findOne(id);
         Subjects updatedSubjects = new Subjects.Builder("211121614")
                 .Subjects(subjects)
                 .Co_ordenator("Mrs E Zietsman")
                 .build();
        
         repo.save(updatedSubjects);
         
         Subjects newSubjects = repo.findOne(id);
         Assert.assertEquals(newSubjects.getCo_ordenator(), "Mrs E Zietsman");
         
     }
     
     @Test(dependsOnMethods = "updateSubjects",enabled = true)
     private void deleteSubjects(){
         repo = ctx.getBean(SubjectsRepository.class);
         Subjects subjects = repo.findOne(id);
         repo.delete(subjects);
         
         Subjects deletedSubjects = repo.findOne(id);      
         Assert.assertNull(deletedSubjects);
  
     }

    @BeforeClass
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
