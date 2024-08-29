package com.junit.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoUtilsLifeCycleMethodTest {
    DemoUtils demoUtils;
    @BeforeEach
    void beforeEachMethod(){
        System.out.println("Before Each method is running...");
        demoUtils = new DemoUtils();
    }
    @AfterEach
    void afterEachMethod(){
        System.out.println("After Each Method --> this will executed after every test method");
    }
    @BeforeAll
    static void beforeAllMethod(){
        System.out.println("Before All Method --> this will executed Before all test method but only once");
    }
    @AfterAll
    static void afterAllMethod(){
        System.out.println("After All Method --> this will executed After all test method but only once");
    }
    @Test// annotate a method with @Test, that show's it is a test method
    void equalsAndNotEquals(){
        System.out.println("Equals And Not Equals method is running...");
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6"); // static import of the assertEquals method and testing the add method
        assertNotEquals(9, demoUtils.add(2,4), "2+4 not must be 9");// static import of the assertEquals method and testing the add method
    }
    @Test
    void equalsNullAndNotNull(){
        System.out.println("Equals Null And Not Null method is running...");
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }
}
