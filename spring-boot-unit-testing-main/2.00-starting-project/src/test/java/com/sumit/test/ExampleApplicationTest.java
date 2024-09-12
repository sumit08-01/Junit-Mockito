package com.sumit.test;

import com.sumit.component.MvcTestingExampleApplication;
import com.sumit.component.models.CollegeStudent;
import com.sumit.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = MvcTestingExampleApplication.class) // if the main/java --> package name is not same as test/java --> Then we got error and we have to resolve like this(by mantioning name application class in this annotation)
public class ExampleApplicationTest {

    public static int count = 0;

    @Value("${info.school.name}")
    private String schoolName;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    ApplicationContext context;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach(){
        count = count+1;
        System.out.println("Testing : " + appName + " Which is " + appDescription + " Version " + appVersion + ". Execution of the test method " + count);

        collegeStudent.setFirstname("sumit");
        collegeStudent.setLastname("Gond");
        collegeStudent.setEmailAddress("sumitgond0000@mgail.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.6, 76.4, 91.25)));
        collegeStudent.setStudentGrades(studentGrades);

    }

    @DisplayName("Add grade result for student grade")
    @Test
    public void addGradeResultForStudentGrade(){
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Add grade result for student grade not equal")
    @Test
    public void addGradeResultForStudentGradeNotEqual(){
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("is grade Grater")
    @Test
    public void isGradeGreaterStudentGrade(){
        assertTrue(studentGrades.isGradeGreater(90, 75), "Failure should be - true");
    }

    @DisplayName("is grade Grater false")
    @Test
    public void isGradeGreaterStudentGradeFalse(){
        assertFalse(studentGrades.isGradeGreater(89, 92), "Failure should be - false");
    }

    @DisplayName("Check null for student grades")
    @Test
    public void checkNullForStudentGrade(){
        assertNotNull(studentGrades.checkNull(collegeStudent.getStudentGrades().getMathGradeResults()), "Object should not be mull");
    }

    @DisplayName("Create student without grade init")
    @Test
    public void createStudentWithoutGradesInit() {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstname("Chad");
        studentTwo.setLastname("Darby");
        studentTwo.setEmailAddress("sumitgond000@gmail.com");
        assertNotNull(studentTwo.getFirstname());
        assertNotNull(studentTwo.getLastname());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }

    @DisplayName("Verify students are prototypes")
    @Test
    public void verifyStudentsArePrototypes() {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);

        assertNotSame(collegeStudent, studentTwo);
    }

    @DisplayName("Find Grade Point Average")
    @Test
    public void findGradePointAverage() {
        assertAll("Testing all assertEquals",
                ()-> assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                        collegeStudent.getStudentGrades().getMathGradeResults())),
                ()-> assertEquals(88.31, studentGrades.findGradePointAverage(
                        collegeStudent.getStudentGrades().getMathGradeResults()))
        );
    }

}
