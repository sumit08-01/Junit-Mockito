package com.junit.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class DemoUtilsILineMatched {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void testLineMatch(){
        List<String> academyInList = List.of("luv", "2", "code");
        assertLinesMatch(academyInList, demoUtils.getAcademyInList(), "Line should match");
    }
}
