/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance;

import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.domain.Student;
import com.cput.classattendance.domain.StudentSubjects;
import com.cput.classattendance.domain.Subjects;
import java.util.Date;
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
public class StudentSubjectsTest {
    
    public StudentSubjectsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() throws Exception {
        
        Student stud = (Student) new Student.Builder("211121614")
                 .Name("Aiden")
                 .surname("Page")
                 .Address("any where")
                 .DOB(new Date())
                 .build();
        
        Subjects sub = (Subjects) new Subjects.Builder("DOS300S")
                 .CourseID("1")
                 .Co_ordenator("Mrs G Khan")
                 .Name("DEVLELOPMENT SOFTWARE 3")
                 .build();
        
        
        ClassDetails clas = (ClassDetails) new ClassDetails
                .Builder()
                .startTime("10:00")
                .endTime("11:30")
                .build();
        
        
         StudentSubjects s = new StudentSubjects.Builder()
                 .StudentID(stud)
                 .SubjectID(sub)
                 .ClassID(clas)
                 .build();
         
         
        Assert.assertEquals(s.getStudentID(), stud);
 
    }

    @Test
    public void testUpdate() throws Exception {
        Student stud = (Student) new Student.Builder("211121614")
                 .Address("else where")
                 .build();
        
        StudentSubjects s = new StudentSubjects.Builder()
                .StudentID(stud)
                 .build();
        Assert.assertEquals(s.getStudentID().getAddress(), "else where");
 
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
