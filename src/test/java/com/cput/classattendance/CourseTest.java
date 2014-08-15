/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Course;
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
public class CourseTest {
    
    public CourseTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreate() throws Exception
    {
        Course c = new Course
                .Builder()
                .CourseID(110)
                .Name("Software Development")
                .Term(3)
                .Type("Boom")
                .build();
        Assert.assertEquals(c.getTerm(),3);
                
    }
    
    @Test
    public void testUpdate() throws Exception
    {
        Course c = new Course
                .Builder()
                .CourseID(110)
                .Name("Software Development")
                .Term(3)
                .Type("Booom")
                .build();
        Assert.assertEquals(c.getType(),"Booom");
                
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
