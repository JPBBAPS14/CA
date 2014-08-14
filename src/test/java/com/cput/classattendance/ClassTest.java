/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.ClassDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class ClassTest {
    
    public ClassTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testCreation() throws Exception {
        String classStart = "2014-08-14 10:00:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String classEnd = "2014-08-14 11:30:00.0";
        ClassDetails c = new ClassDetails
                .Builder()
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd))
                .build();
                
        Assert.assertEquals(c.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd));
  }

    @Test
    public void testUpdate() throws Exception {
        String classStart = "2014-08-14 08:30:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String classEnd = "2014-08-14 10:00:00.0";
        ClassDetails c = new ClassDetails
                .Builder()
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd))
                .build();
        
        Assert.assertEquals(c.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd));
 
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
