/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Lecturer;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jean-Paul
 */
public class LecturerTest {
    
    public LecturerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testCreation() throws Exception {
        Lecturer l = new Lecturer
            .Builder()
                .email("123leonsmall123@hotmail.com")
                .name("Leon Small")
                .officeRoom("8.1")
                .telephone_no(021123312)
                .build();
                
        Assert.assertEquals(l.getName(), "Leon Small");
 
    }

    @Test
    public void testUpdate() throws Exception {
        Lecturer l = new Lecturer
            .Builder()
                .email("123leonsmall123@hotmail.com")
                .name("Leon Big")
                .officeRoom("8.1")
                .telephone_no(021123312)
                .build();
                
        Assert.assertEquals(l.getName(), "Leon Big");
 
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
