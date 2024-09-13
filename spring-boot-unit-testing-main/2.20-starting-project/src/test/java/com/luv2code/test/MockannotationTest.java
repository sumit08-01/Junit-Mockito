package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockannotationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

//    @Mock
    @MockBean
    private ApplicationDao applicationDao;

//    @InjectMocks
    @Autowired
    private ApplicationService service;

    @BeforeEach
    public void beforeEach(){
        studentOne.setFirstname("sumit");
        studentOne.setLastname("Gond");
        studentOne.setEmailAddress("sumit9999000@gmail.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    public void assertEqualsTestAddGrade(){
    when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);
    assertEquals(100, service.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));

    verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @DisplayName("Find Gpa")
    @Test
    public void assertEqualsTestFindGpa(){
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);
        assertEquals(88.31, service.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull(){
        when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);
        assertNotNull(service.checkNull(studentOne.getStudentGrades().getMathGradeResults()), "Object should not be null");
    }

    @DisplayName("Throw Runtime error")
    @Test
    public void throwRuntimeError(){
        CollegeStudent nullStudent = (CollegeStudent) applicationContext.getBean("collegeStudent");
        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);
        assertThrows(RuntimeException.class, ()->{
            service.checkNull(nullStudent);
        });
        verify(applicationDao, times(1)).checkNull(nullStudent);
    }

    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls() {
        CollegeStudent nullStudent = (CollegeStudent) applicationContext.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Do not throw exception second time");

        assertThrows(RuntimeException.class, () -> {
            service.checkNull(nullStudent);
        });

        assertEquals("Do not throw exception second time",
                service.checkNull(nullStudent));

        verify(applicationDao, times(2)).checkNull(nullStudent);
    }

}
