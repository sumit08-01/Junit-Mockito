package com.junit.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DemoUtilsAssertitionArrayDeplyEquals {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void testArrayEquals(){
//        String first3array[] = {"A", "B", "z"}; Expected :z //Actual   :C
        String first3array[] = {"A", "B", "C"};
        assertArrayEquals(first3array, demoUtils.getFirstThreeLettersOfAlphabet(), "Array should be the same");
    }
}
