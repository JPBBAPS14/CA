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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
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
    // @Test
    // public void hello() {}
//    @Test
//    public void testCreation() throws Exception {
//        
//        List<Student> stud = (List<Student>) new Student.Builder("211121614")
//                 .Name("Aiden")
//                 .surname("Page")
//                 .Address("any where")
//                 .DOB(new Date())
//                 .build();
//        
//        List<Subjects> sub = (List<Subjects>) new Subjects.Builder("DOS300S")
//                 .CourseID("1")
//                 .Co_ordenator("Mrs G Khan")
//                 .Name("DEVLELOPMENT SOFTWARE 3")
//                 .build();
//        
//        String classStart = "2014-08-14 10:00:00.0";
//        String date = "2014-08-14 10:00:00.0";
//        String end = "2014-08-14 11:30:00.0";

//        
//        List<ClassDetails> clas = (List<ClassDetails>) new ClassDetails
//                .Builder()
//                .startTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(classStart))
//                .endTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(end))
//                .build();
//        
//        
//         StudentSubjects s = new StudentSubjects.Builder(stud)
//                 .SubjectID(sub)
//                 .ClassID(clas)
//                 .build();
//         
//         
//         List<Student> stu = (List<Student>) new Student.Builder("211121614")
//                 .Name("Aiden")
//                 .surname("Page")
//                 .Address("any where")
//                 .DOB(new Date())
//                 .build();
//         
//        Assert.assertEquals(s.getStudentID(), stu);
// 
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        StudentSubjects s = new StudentSubjects.Builder(null)
//                .ClassID(null)
//                 .build();
//        Assert.assertEquals(s.getClassID(), "else where");
// 
//    }
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
