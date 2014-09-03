/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cput.classattendance.test.repository;

import com.cput.classattendance.domain.ClassDetails;
import com.cput.classattendance.domain.Lecturer;
import com.cput.classattendance.domain.Student;
import com.cput.classattendance.domain.StudentSubjects;
import com.cput.classattendance.domain.Subjects;
import com.cput.classattendance.repository.ClassDetailsRepository;
import com.cput.classattendance.repository.LecturerRepository;
import com.cput.classattendance.repository.StudentRepository;
import com.cput.classattendance.repository.StudentSubjectsRepository;
import com.cput.classattendance.repository.SubjectsRepository;
import com.cput.classattendance.test.ConnectionConfigTest;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author Aidem
 */
public class StudentSubjectsRepositoryTest {
    
    
     public static ApplicationContext ctx;
    private Long id;
    
    private StudentSubjectsRepository repo;
    private StudentRepository repo1;
    private SubjectsRepository repo2;
    private LecturerRepository repo3;
    private ClassDetailsRepository repo4;
       
    public StudentSubjectsRepositoryTest() {
    }

     @org.testng.annotations.Test (enabled = true)
     public void createStudentSubjects() {
         repo = ctx.getBean(StudentSubjectsRepository.class);
         repo1 = ctx.getBean(StudentRepository.class);
         repo2 = ctx.getBean(SubjectsRepository.class);
         repo3 = ctx.getBean(LecturerRepository.class);
         repo4 = ctx.getBean(ClassDetailsRepository.class);

         Student stud = (Student) new Student.Builder("211121614")
                 .Name("Aiden")
                 .surname("Page")
                 .Address("any where")
                 .DOB(new Date())
                 .build();
         
         repo1.save(stud);
         id = stud.getId();
         Assert.assertNotNull(stud);
        
        Subjects sub = (Subjects) new Subjects.Builder("DOS300S")
                 .CourseID("1")
                 .Co_ordenator("Mrs G Khan")
                 .Name("DEVLELOPMENT SOFTWARE 3")
                 .build();
        
        repo2.save(sub);
         id = sub.getId();
         Assert.assertNotNull(sub);
        
        Lecturer lec = new Lecturer.Builder()
                .email("123leonsmall123@hotmail.com")
                .name("Leon Small")
                .officeRoom("8.1")
                .telephone_no(021123312)
                .build();
        
        repo3.save(lec);
         id = lec.getId();
         Assert.assertNotNull(lec);
        
        
        ClassDetails clas = (ClassDetails) new ClassDetails.Builder()
                .lecturerID(lec)
                .startTime("10:00")
                .endTime("11:30")
                .build();
        
        repo4.save(clas);
         id = clas.getId();
         Assert.assertNotNull(clas);
        
        
         StudentSubjects s = new StudentSubjects.Builder()
                 .StudentID(stud)
                 .SubjectID(sub)
                 .ClassID(clas)
                 .build();
         
         repo.save(s);
         id = s.getId();
         Assert.assertNotNull(s); 
     }
     
     @Test(dependsOnMethods = "createStudentSubjects", enabled = true)
     public void readStudentSubjects(){
         repo = ctx.getBean(StudentSubjectsRepository.class);
         repo1 = ctx.getBean(StudentRepository.class);
         StudentSubjects studentSubjects = repo.findOne(id);
         Assert.assertEquals(studentSubjects.getStudentID().getStudentID(), "211121614");
         
     }
     
    @org.testng.annotations.Test(dependsOnMethods = "readStudentSubjects", enabled = true)
     private void updateStudentSubjects(){
         repo = ctx.getBean(StudentSubjectsRepository.class);
         repo1 = ctx.getBean(StudentRepository.class);
         
         Student stud = repo1.findOne(id);
         
         Student updatedstud = (Student) new Student.Builder("211121614")
                 .Student(stud)
                 .Address("some where else")
                 .build();
         repo1.save(updatedstud);
         
         StudentSubjects studentSubjects = repo.findOne(id);
         
         StudentSubjects updatedStudentSubjects = new StudentSubjects.Builder()
                 .StudentSubjects(studentSubjects)
                 .StudentID(updatedstud)
                 .build();
        
         repo.save(updatedStudentSubjects);
         
         StudentSubjects newStudentSubjects = repo.findOne(id);
         Assert.assertEquals(newStudentSubjects.getStudentID().getAddress(), "some where else");
         
     }
     
     @Test(dependsOnMethods = "updateStudentSubjects",enabled = true)
     private void deleteStudentSubjects(){
         repo = ctx.getBean(StudentSubjectsRepository.class);
         StudentSubjects studentSubjects = repo.findOne(id);
         repo.delete(studentSubjects);
         
         StudentSubjects deletedStudent = repo.findOne(id);      
         Assert.assertNull(deletedStudent);
  
     }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
        	 ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
		
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
