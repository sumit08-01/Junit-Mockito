package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestPropertySource("/application.properties")
@SpringBootTest
public class GradeBookControllerTest {

    private static MockHttpServletRequest request;

    @Autowired
    private JdbcTemplate template;

    @Mock
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private MockMvc mockMvc;


    @BeforeAll
    public static void setup(){
        request = new MockHttpServletRequest();
        request.setParameter("firstname", "sumit1");
        request.setParameter("lastname", "gond1");
        request.setParameter("emailAddress", "sumitgond8745@gmail.com");

    }

    @BeforeEach
    public void setupDataBase(){
        template.execute("insert into student(id, firstname, lastname, email_address)" +
                "values(1, 'sumit', 'gond', 'sumitgond9999@gmail.com')" );
    }

    @Test
    public void getStudentsHttpRequest() throws Exception{

        CollegeStudent collegeStudentOne = new CollegeStudent("sumit", "gond", "sumitgond9999@gmail.com");
        CollegeStudent collegeStudentTwo = new CollegeStudent("sourabh", "gautam", "sourabh9999@gmail.com");

        List<CollegeStudent> collegeStudentList = new ArrayList<>(Arrays.asList(collegeStudentOne, collegeStudentTwo));

        when(studentService.getGradeBook()).thenReturn(collegeStudentList);
        assertIterableEquals(collegeStudentList, studentService.getGradeBook());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).andReturn();
        ModelAndView mav = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(mav,"index");

    }

    @Test
    public void createStudentHttpRequest() throws Exception{

        MvcResult result = this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("firstname", request.getParameterValues("firstname"))
                .param("firstnamelastname", request.getParameterValues("lastname"))
                .param("emailAddress", request.getParameterValues("emailAddress")))
                .andExpect(status().isOk()).andReturn();

        ModelAndView mav = result.getModelAndView();
        ModelAndViewAssert.assertViewName(mav,"index");

        CollegeStudent verifyStudent = studentDao.findByEmailAddress("sumitgond8745@gmail.com");
        assertNotNull(verifyStudent, "Student should be found");

    }

    @AfterEach
    public void setupAfterTransaction(){
        template.execute("delete from student");
    }
}
