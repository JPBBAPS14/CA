/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.test.repository;

import com.cput.classattendance.app.conf.ConfConnectionConfig;
import com.cput.classattendance.domain.Lecturer;
import com.cput.classattendance.repository.LecturerRepository;
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
public class LecturerRepositoryTest {

    public LecturerRepositoryTest() {
    }
    public static ApplicationContext ctx;
    private Long id;

    private LecturerRepository repo;

    @Test
    public void createLecturer() {

        repo = ctx.getBean(LecturerRepository.class);
        Lecturer l = new Lecturer.Builder()
                .email("123leonsmall123@hotmail.com")
                .name("Leon Small")
                .officeRoom("8.1")
                .telephone_no(021123312)
                .build();

        repo.save(l);
        id = l.getId();
        Assert.assertNotNull(l);

    }

    @Test(dependsOnMethods = "createLecturer")
    public void readLecturer() {
        repo = ctx.getBean(LecturerRepository.class);
        Lecturer b = repo.findOne(id);
        Assert.assertEquals(b.getName(), "Leon Small");

    }

    @Test(dependsOnMethods = "readLecturer")
    private void updateLecturer() {
        repo = ctx.getBean(LecturerRepository.class);
        Lecturer b = repo.findOne(id);
        Lecturer l = new Lecturer.Builder()
                .email("123leonsmall123@hotmail.com")
                .name("jj  abrahams")
                .officeRoom("8.1")
                .telephone_no(021123312)
                .build();

        repo.save(l);

        Lecturer newLecturer = repo.findOne(id);
        Assert.assertEquals(newLecturer.getName(), "jj  abrahams");//201.0

    }

    @Test(dependsOnMethods = "updateLecturer")
    private void deleteLecturer() {
        repo = ctx.getBean(LecturerRepository.class);
        Lecturer b = repo.findOne(id);
        repo.delete(b);

        Lecturer deletedLecturer = repo.findOne(id);

        Assert.assertNull(deletedLecturer);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConfConnectionConfig.class);

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
