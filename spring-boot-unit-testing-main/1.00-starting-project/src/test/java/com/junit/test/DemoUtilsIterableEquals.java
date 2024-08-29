package com.junit.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DemoUtilsIterableEquals {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void testIterableEquals(){
        List<String> academyInList = List.of("luv", "2", "code");
        assertIterableEquals(academyInList, demoUtils.getAcademyInList(), "Expected List should be same as actual list");
    }
}
