package com.junit.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTestOrderByNumbers {


    @Order(4)
    @Test // annotate a method with @Test, that show's it is a test method
    void equals_And_NotEquals(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6"); // static import of the assertEquals method and testing the add method
        assertNotEquals(9, demoUtils.add(2,4), "2+4 not must be 9");// static import of the assertEquals method and testing the add method
    }

    @Order(1)
    @Test
    void equalsNull_And_NotNull(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Order(3)
    @Test
    void vandom1(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Order(-2)
    @Test
    void zandom3(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Order(2)
    @Test
    void aandom2(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }




}
