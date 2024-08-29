package com.junit.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class DemoUtilsCustomDisplayNameTest {
    @DisplayName("Equals and NotEquals")
    @Test // annotate a method with @Test, that show's it is a test method
    void equals_And_NotEquals(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6"); // static import of the assertEquals method and testing the add method
        assertNotEquals(9, demoUtils.add(2,4), "2+4 not must be 9");// static import of the assertEquals method and testing the add method
    }
    @DisplayName("Null and NotNull")
    @Test
    void equalsNull_And_NotNull(){
        DemoUtils demoUtils = new DemoUtils(); // Create object of the class which you want to test
        String str1 = null;
        String str2 = "sumit";
        assertNull(demoUtils.checkNull(str1), "Str1 is null");
        assertNotNull(demoUtils.checkNull(str2), "Str2 is not null");
    }
}
