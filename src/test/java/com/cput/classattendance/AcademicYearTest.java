/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.AcademicYear;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author sandisiwe
 */
public class AcademicYearTest {
    
    public AcademicYearTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() throws Exception{
     
         AcademicYear a = new AcademicYear.Builder("210130067").build();
         Assert.assertEquals(a.getAcademicID(), "210130067");        
     
     }
     
     @Test
      public void testUpdate() throws Exception {
         AcademicYear a = new AcademicYear.Builder("211003344").build();
         Assert.assertEquals(a.getAcademicID(), "211003344");  
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
