/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.DaoTests;

import com.cput.classattendance.dao.ClassDetailsDAO;
import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.repository.ClassDetailsRepository;
import com.cput.classattendance.test.ConnectionConfigTest;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Rafiq(Fiki)
 */
public class ClassDetailsDaoTest {
    
    public static ApplicationContext ctx;
    private Long id; 
    
    //Get repository
    private ClassDetailsDAO dao;        
    
    public ClassDetailsDaoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test (enabled = true)
     public void createClassDetails()
     {
         dao = ctx.getBean(ClassDetailsDAO.class);         
         ClassDetails object = new ClassDetails.Builder()
                 .startTime("10:00") 
                 .endTime("11:30")                 
                 .build();
         
         dao.create(object);
         id = object.getId();
         System.out.println(id);
         Assert.assertNotNull(object);
     }
     
     @Test(dependsOnMethods = "createClassDetails", enabled = true)
     public void readClassDetails()
     {
         dao = ctx.getBean(ClassDetailsDAO.class);
         ClassDetails object = dao.getRecord(id);
         Assert.assertEquals(object.getStartTime(), "10:00");         
     }
     
    @Test(dependsOnMethods = "readClassDetails", enabled = true)
     public void updateClassDetails()
     {
        dao = ctx.getBean(ClassDetailsDAO.class);
         
        //********New values*********
        //Starting times
        String classStart = "2014-08-14 08:30:00.0";
        
        //Ending time
        String classEnd = "2014-08-14 10:00:00.0";
        
        //New object 
        ClassDetails object = new ClassDetails.Builder()
                  .id(id)
                 .startTime(classStart) 
                 .endTime(classEnd)                 
                 .build();       

        //Update , pass id and pass new object
        dao.updateRecord(id,object);
       
        ClassDetails newClassDetails = dao.getRecord(id);
        
        Assert.assertEquals(newClassDetails.getEndTime(), classEnd);
     }
     
     @Test(dependsOnMethods = "updateClassDetails", enabled = true)
     public void deleteClassDetails()
     {
         dao = ctx.getBean(ClassDetailsDAO.class);
         ClassDetails object = dao.getRecord(id);
         
         dao.deleteRecord(object);
         
         ClassDetails deletedDepartment = dao.getRecord(id);
         
         Assert.assertNull(deletedDepartment);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
          ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
