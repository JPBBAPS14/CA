/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.Faculty;
import com.cput.classattendance.repository.FacultyRepository;
import org.testng.Assert;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Bradz
 */
public class FacultyRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private FacultyRepository repo;
    
    public FacultyRepositoryTest() {
    }

    // TODO add test methods here.
  
        
    @Test (enabled = true)
    public void createFaculty()
    {
        repo = ctx.getBean(FacultyRepository.class);
        Faculty f = new Faculty.Builder()
                .FacultyID(101)
                .Name("Informatics + Design")
                .build();
        
        repo.save(f);
        id = f.getID();
        System.out.println(id);
        Assert.assertNotNull(f);
    }
    
    @Test(dependsOnMethods = "createFaculty", enabled = true)
     public void readFaculty()
     {
         repo = ctx.getBean(FacultyRepository.class);
         Faculty f = repo.findOne(id);
         Assert.assertEquals(f.getFacultyID(),101);
     }
     
     @Test(dependsOnMethods = "readStudent", enabled = true)
     private void updateFaculty()
     {
         repo = ctx.getBean(FacultyRepository.class);
         Faculty f = repo.findOne(id);
         Faculty updatedFaculty = new Faculty.Builder()
                 .Name("Informatics And Design")
                 .build();
         repo.save(updatedFaculty);
         Faculty newFaculty = repo.findOne(id);
         Assert.assertEquals(newFaculty.getName(), "Informatics And Design");
     }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
