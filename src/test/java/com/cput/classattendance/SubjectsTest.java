/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Subjects;
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
public class SubjectsTest {
    
    public SubjectsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreation() throws Exception {
        Subjects s = new Subjects.Builder("DOS300S")
                 .CourseID("1")
                 .Co_ordenator("Mrs G Khan")
                 .Name("DEVLELOPMENT SOFTWARE 3")
                 .build();
        Assert.assertEquals(s.getSubjectID(), "DOS300S");
 
    }

    @Test
    public void testUpdate() throws Exception {
        Subjects s = new Subjects.Builder("DOS300S")
                 .Co_ordenator("Mrs E Zietsman")
                 .build();
        Assert.assertEquals(s.getCo_ordenator(), "Mrs E Zietsman");
 
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
