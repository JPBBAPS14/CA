/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.test.repository;

import com.cput.classattendance.app.conf.ConfConnectionConfig;
import com.cput.classattendance.domain.Exams;
import com.cput.classattendance.repository.ExamsRepository;
import com.cput.classattendance.repository.StudentRepository;
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
public class ExamsRepositoryTest {

    public static ApplicationContext ctx;
    private Long id;

    private ExamsRepository repo;

    public ExamsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled = true)
    public void createExams() throws ParseException {
        String classStart = "2014-08-14 10:00:00.0";
        String date = "2014-08-14 10:00:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String end = "2014-08-14 11:30:00.0";
        repo = ctx.getBean(ExamsRepository.class);
        Exams e = new Exams.Builder()
                .startTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(date))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(end))
                .subject("Development Softtware 3")
                .venue("2.11 engineering")
                .build();
        repo.save(e);
        id = e.getId();
        Assert.assertNotNull(e);
    }

    @Test(dependsOnMethods = "createExams", enabled = true)
    public void readExams() {
        repo = ctx.getBean(ExamsRepository.class);
        Exams e = repo.findOne(id);
        Assert.assertEquals(e.getSubject(), "Development Softtware 3");

    }

    @Test(dependsOnMethods = "readExams", enabled = true)
    private void updateSExams() throws ParseException {

        String classStart = "2014-08-14 10:00:00.0";
        String date = "2014-08-14 10:00:00.0";
        //Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        String end = "2014-08-14 11:30:00.0";

        repo = ctx.getBean(ExamsRepository.class);
        Exams exams = repo.findOne(id);
        Exams updatedExams = new Exams.Builder()
                .Exams(exams)
                .startTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
                .date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(date))
                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(end))
                .subject("Development Softtware 2")
                .venue("2.11 engineering")
                .build();
         repo.save(updatedExams);

        Exams newExams = repo.findOne(id);
        Assert.assertEquals(newExams.getSubject(), "Development Softtware 2");

    }
    
    @Test(dependsOnMethods = "updateExams",enabled = true)
     private void deleteExams(){
         repo = ctx.getBean(ExamsRepository.class);
         Exams exams = repo.findOne(id);
         repo.delete(exams);
         
         Exams deletedExams = repo.findOne(id);      
         Assert.assertNull(deletedExams);
  
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
