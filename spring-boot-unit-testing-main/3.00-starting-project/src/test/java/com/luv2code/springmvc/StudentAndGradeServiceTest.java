package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@TestPropertySource("/application.properties") //This will fetch the external properties from the application.properties
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private JdbcTemplate template;
    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @BeforeEach
    public void setupDataBase(){
    template.execute("insert into student(id, firstname, lastname, email_address)" +
            "values(1, 'sumit', 'gond', 'sumitgond9999@gmail.com')" );
    }

    @Test
    public void createStudentService(){
        studentService.createStudent("sumit", "Gond",
                "sumitgond9999@gmail.com");
      CollegeStudent student = studentDao.
              findByEmailAddress("sumitgond9999@gmail.com");
        assertEquals("sumitgond9999@gmail.com",
                student.getEmailAddress(),"find By email");
    }

    @Test
    public void isStudentNullCheck(){
        assertTrue(studentService.checkIfStudentIsNull(1));
        assertFalse(studentService.checkIfStudentIsNull(0));
    }

    @Test
    public void deleteStudentService(){
        Optional<CollegeStudent> deleteCollegeStudent = studentDao.findById(1);
        assertTrue(deleteCollegeStudent.isPresent(), "Return true");
        studentService.deleteStudent(1);
        Optional<CollegeStudent> deleteCollegeStudentcheck = studentDao.findById(1);
        assertFalse(deleteCollegeStudentcheck.isPresent(), "Return false");

    }

    @Sql("/insertData.sql") // Execute the sql before the test method, @Before execute first then execute sql
    @Test
    public void getGradeBookService(){
       Iterable<CollegeStudent> iterableCollegeStudent = studentService.getGradeBook();
       List<CollegeStudent> collegeStudents = new ArrayList<>();
       for(CollegeStudent collegeStudent : iterableCollegeStudent){
           collegeStudents.add(collegeStudent);
       }
//       assertEquals(1,collegeStudents.size());
        assertEquals(5,collegeStudents.size()); // for 5 records
    }

    @AfterEach
    public void setupAfterTransaction(){
        template.execute("delete from student");
    }
}
