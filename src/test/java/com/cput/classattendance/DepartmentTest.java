/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.Department;
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
public class DepartmentTest {
    
    public DepartmentTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test    
    public void testCreation() throws Exception
    {
        Department dep = new Department
                .Builder()
                    .deptID(111) 
                    .name("ND: Information Technology")
                    .conDetails("Tel: +27 21 460 3911")
                    .facID(111)
                    .build();
                
        Assert.assertEquals(dep.getName(),"ND: Information Technology");
    }
    
    @Test    
    public void testUpdate() throws Exception
    {
        Department dep = new Department
                .Builder()
                    .deptID(111) 
                    .name("ND: Information Technology")
                    .conDetails("Tel: +27 21 460 3910")
                    .facID(111)
                    .build();
                
        Assert.assertEquals(dep.getContactDetails(),"Tel: +27 21 460 3910");
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
