/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Faculty;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 209215178
 */
public class FacultyTest {
    
    public FacultyTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() throws Exception
     {
         Faculty fac = new Faculty
                 .Builder()
                 .FacultyID(101)
                 .Name("ND: Information Technology")
                 .build();
         
         Assert.assertEquals(fac.getFacultyID(),101);
     }
     
     @Test
     public void testUpdate() throws Exception
     {
         Faculty fac = new Faculty
                 .Builder()
                 .FacultyID(101)
                 .Name("Informatics And Design")
                 .build();
         
         Assert.assertEquals(fac.getName(),"Informatics And Design");
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
