package com.junit.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DemoUtilsTrueOrFalseSame {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    @DisplayName("True or false")
    void testTrueOrFalse(){
        int n1 = 10;
        int n2 = 5;
        assertTrue(demoUtils.isGreater(n1,n2), "This should be true");
        assertFalse(demoUtils.isGreater(n2,n1), "This should be false");
    }
}
