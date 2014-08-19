/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.ClassAcademic;
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
public class ClassAcademicTest {
    
    public ClassAcademicTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
  
    @Test
     public void testCreation() throws Exception{
         ClassAcademic c = new ClassAcademic.Builder("21012003")
                            .classID("1.11")
                            .vanue("1st floor Eng Building")
                            .build();
         Assert.assertEquals(c.getClassID(), "1.11");
     }
     
     
     @Test
     public void updateCreation() throws Exception{
         ClassAcademic c = new ClassAcademic.Builder("21012003")
                            .classID("1.32")
                            .vanue("1st floor Eng Building")
                            .build();
         Assert.assertEquals(c.getClassID(), "1.32");
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
