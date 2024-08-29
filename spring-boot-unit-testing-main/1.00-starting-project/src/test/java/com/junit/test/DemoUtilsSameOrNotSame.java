package com.junit.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DemoUtilsSameOrNotSame {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void testSameOrNotSame(){
        String str = "sumitgond";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Object should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Object should not refere to the same object");
    }
}
