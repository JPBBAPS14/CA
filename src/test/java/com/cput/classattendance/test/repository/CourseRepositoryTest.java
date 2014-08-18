/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.Course;
import com.cput.classattendance.repository.CourseRepository;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Bradz
 */
public class CourseRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private CourseRepository repo;
    
    public CourseRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
  
        
    //
    @Test(enabled = true)
    public void createCourse()
    {
        repo = ctx.getBean(CourseRepository.class);
        Course c = new Course.Builder()
                .CourseID(1001)
                .DepartmentID(100)
                .Name("ND:Information Technology")
                .Term(3)
                .Type("Software Development")
                .build();
        repo.save(c);
        id = c.getId();
        System.out.println(id);
        Assert.assertNotNull(c);        
    }
    
     @Test(dependsOnMethods = "createCourse", enabled = true)
     public void readCourse()
     {
         repo = ctx.getBean(CourseRepository.class);
         Course c = repo.findOne(id);
         Assert.assertEquals(c.getCourseID(),"1001");
     }
     
     @Test(dependsOnMethods = "readCourse", enabled = true)
     private void updateCourse()
     {
         repo = ctx.getBean(CourseRepository.class);
         Course c = repo.findOne(id);
         Course updatedCourse = new Course.Builder()
                 .Course(c)
                 .Name("National Diploma: Information Technology")
                 .build();
         repo.save(updatedCourse);
         
         Course newCourse = repo.findOne(id);
         Assert.assertEquals(newCourse.getName(), "National Diploma: Information Technology");
     }
     
     @Test(dependsOnMethods = "updateCourse",enabled = true)
     private void deleteCourse()
     {
         repo = ctx.getBean(CourseRepository.class);
         Course c = repo.findOne(id);
         
         repo.delete(c);
         
         Course deletedCourse = repo.findOne(id);
         Assert.assertNull(deletedCourse);
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
