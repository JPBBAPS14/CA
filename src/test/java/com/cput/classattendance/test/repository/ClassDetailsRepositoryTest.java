/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.test.repository;

import com.cput.classattendance.app.conf.ConfConnectionConfig;
import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.repository.ClassDetailsRepository;
import com.cput.classattendance.test.ConnectionConfigTest;
import static com.cput.classattendance.test.repository.ClassDetailsRepositoryTest.ctx;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class ClassDetailsRepositoryTest {

    public ClassDetailsRepositoryTest() {
    }
    public static ApplicationContext ctx;
    private Long id;

    private ClassDetailsRepository repo;

    @Test
    public void createClassDetails() throws ParseException {

        repo = ctx.getBean(ClassDetailsRepository.class);
        String classStart = "2014-08-14 10:00:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String classEnd = "2014-08-14 11:30:00.0";
        ClassDetails c = new ClassDetails
                .Builder()
                .startTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd))
                .build();

        repo.save(c);
        id = c.getId();
        Assert.assertNotNull(c);

    }

    @Test(dependsOnMethods = "createClassDetails")
    public void readClassDetails() throws ParseException {
        repo = ctx.getBean(ClassDetailsRepository.class);
        ClassDetails b = repo.findOne(id);
        String classEnd = "2014-08-14 11:30:00.0";
        Assert.assertEquals(b.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd));

    }

    @Test(dependsOnMethods = "readClassDetails")
    private void updateClassDetails() throws ParseException {
        repo = ctx.getBean(ClassDetailsRepository.class);
        ClassDetails b = repo.findOne(id);
        String classStart = "2014-08-14 08:30:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String classEnd = "2014-08-14 10:00:00.0";
        ClassDetails c = new ClassDetails
                .Builder()
                .startTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd))
                .build();

        repo.save(c);

        ClassDetails newClassDetails = repo.findOne(id);
        Assert.assertEquals(newClassDetails.getEndTime(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classEnd));//201.0

    }

    @Test(dependsOnMethods = "updateClassDetails")
    private void deleteClassDetails() {
        repo = ctx.getBean(ClassDetailsRepository.class);
        ClassDetails b = repo.findOne(id);
        repo.delete(b);

        ClassDetails deletedClassDetails = repo.findOne(id);

        Assert.assertNull(deletedClassDetails);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);

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
