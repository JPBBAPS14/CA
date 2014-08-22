/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.domain.Subjects;
import com.cput.classattendance.repository.ClassDetailsRepository;
import com.cput.classattendance.services.AllClassesStartingService;
import org.springframework.context.ApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 211064084
 */
public class AllClassesStartingServiceTest {
    
    public AllClassesStartingServiceTest() {
    }

    public static ApplicationContext ctx;
    private Long id;
    private ClassDetailsRepository classDetailsRepository;
    private AllClassesStartingService allClassesStartingService;
    
    @Test
    public void getClassesStartingAt(){
        classDetailsRepository = ctx.getBean(ClassDetailsRepository.class);
        allClassesStartingService = ctx.getBean(AllClassesStartingService.class);
        
        ClassDetails cd1 = new ClassDetails
                .Builder()
                .startTime("2014-08-24 10:00")
                .endTime("2014-08-23 11:30")
                .build();
        
        Subjects s1 = new Subjects.Builder("TP300S")
                .Name("Technical Programming 3")
                .build();
                
        ClassDetails cd2 = new ClassDetails
                .Builder()
                .startTime("2014-08-24 10:00")
                .endTime("2014-08-23 11:30")
                .build();
        
        Subjects s2 = new Subjects.Builder("DS300S")
                .Name("Development Software 3")
                .build();
        
        ClassDetails cd3 = new ClassDetails
                .Builder()
                .startTime("2014-08-25 11:30")
                .endTime("2014-08-23 12:00")
                .build();
        
        Subjects s3 = new Subjects.Builder("IRP300")
                .Name("Internet Programming 3")
                .build();
        
        
        
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
