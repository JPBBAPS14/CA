/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.Department;
import com.cput.classattendance.repository.DepartmentRepository;
import static org.eclipse.persistence.jpa.jpql.JPAVersion.value;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Bradz
 */
public class DepartmentRepositoryTest {
        
    public static ApplicationContext ctx;
    private Long id;
    
    private DepartmentRepository repo;
    
    public DepartmentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test (enabled = true)
     public void createDepartment()
     {
         repo = ctx.getBean(DepartmentRepository.class);
         Department d = new Department.Builder()
                 .deptID(111) 
                 .name("ND: Information Technology")
                 .conDetails("Tel: +27 21 460 3911")
                 .facID(111)
                 .build();
         
         repo.save(d);
         id = d.getId();
         System.out.println(id);
         Assert.assertNotNull(d);
     }
     
      @Test(dependsOnMethods = "createDepartment", enabled = true)
     public void readDepartment()
     {
         repo = ctx.getBean(DepartmentRepository.class);
         Department d = repo.findOne(id);
         Assert.assertEquals(d.getDepartmentID(), "111");
     }
     
     @Test(dependsOnMethods = "readDepartment", enabled = true)
     public void updateDepartment()
     {
         repo = ctx.getBean(DepartmentRepository.class);
         Department d = repo.findOne(id);
         Department updatedDepartment = new Department.Builder()
                 .Department(d)
                 .name("National Diploma: Information Technology")
                 .build();
         repo.save(updatedDepartment);
         
         Department newDepartment = repo.findOne(id);
         Assert.assertEquals(newDepartment.getName(), "National Diploma: Information Technology");
     }
     
     @Test(dependsOnMethods = "updateDepartment", enabled = true)
     public void deleteDepartment()
     {
         repo = ctx.getBean(DepartmentRepository.class);
         Department d = repo.findOne(id);
         repo.delete(d);
         
         Department deletedDepartment = repo.findOne(id);
         Assert.assertNull(deletedDepartment);
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
