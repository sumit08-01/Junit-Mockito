package com.junit.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
class DemoUtilsCustomDisplayNameTestOrderByMethodName {

    @Test // annotate a method with @Test, that show's it is a test method
    void equals_And_NotEquals(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6"); // static import of the assertEquals method and testing the add method
        assertNotEquals(9, demoUtils.add(2,4), "2+4 not must be 9");// static import of the assertEquals method and testing the add method
    }
    @Test
    void equalsNull_And_NotNull(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Test
    void vandom1(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Test
    void zandom3(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }

    @Test
    void aandom2(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }




}
