package com.junit.test;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class DemoUtilsTimeOut {
    DemoUtils demoUtils = new DemoUtils();
    @Test
    void checkTimeOut(){
        assertTimeoutPreemptively(Duration.ofSeconds(8), () -> {demoUtils.checkTimeout();}, "Method should execute in 3 seconds");
    }
}

