package com.junit.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoUtilsThrowAndNotThrow {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void testThrowAndDoesNotThrow(){
        assertThrows(Exception.class, () -> demoUtils.throwException(-1));
        assertDoesNotThrow(() -> demoUtils.throwException(4));
    }
}
