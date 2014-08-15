/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Student;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Aidem
 */
public class StudentTest {
    
    public StudentTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testCreation() throws Exception {
         Student s = new Student.Builder("211121614")
                 .Name("Aiden")
                 .surname("Page")
                 .Address("any where")
                 .DOB(new Date())
                 .build();
        Assert.assertEquals(s.getStudentID(), "211121614");
 
    }

    @Test
    public void testUpdate() throws Exception {
        Student s = new Student.Builder("211121614")
                 .Address("else where")
                 .build();
        Assert.assertEquals(s.getAddress(), "else where");
 
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
