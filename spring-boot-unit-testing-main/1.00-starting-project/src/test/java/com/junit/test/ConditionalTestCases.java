package com.junit.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTestCases {

    // @Disabled and @EnabledOnOs(OS.WINDOWS)

//    @Test
//    @Disabled
//    public void disableTest(){
//        System.out.println("Disable test cases");
//    }

//    @Test
//    @EnabledOnOs(OS.WINDOWS)
//    public void testForWindowOnly(){
//        System.out.println("Test case for window only");
//    }

//    @Test
//    @EnabledOnOs(OS.MAC)
//    public void testForMac(){
//        System.out.println("Test case for Mac");
//    }

//    @Test
//    @EnabledOnOs({OS.WINDOWS, OS.MAC})
//    public void testForWindowAndMac(){
//        System.out.println("Test case for window And Mac");
//    }

    //EnableOnJre and EnableForJreRange
//    @Test
//    @EnabledOnJre(JRE.JAVA_17)
//    public void testForOnlyJava17(){
//        System.out.println("Test case for only java version 17");
//    }

//    @Test
//    @EnabledOnJre(JRE.JAVA_13)
//    public void testForOnlyJava13(){
//        System.out.println("Test case for only java version 13");
//    }

//    @Test
//    @EnabledOnJre(JRE.JAVA_20)
//    public void testForOnlyJava20(){
//        System.out.println("Test case for only java version 20");
//    }

//    @Test
//    @EnabledForJreRange(min = JRE.JAVA_13, max = JRE.JAVA_20)
//    public void testForOnlyrange13To20(){
//        System.out.println("Test case for only java version 13 to 20");
//    }

//    @Test
//    @EnabledForJreRange(min = JRE.JAVA_13)
//    public void testForOnlyGreater13(){
//        System.out.println("Test case for only for minimum java version 13");
//    }

//    @Test
//    @EnabledForJreRange(max = JRE.JAVA_14)
//    public void testForOnlyless14(){
//        System.out.println("Test case for only for maximum java  version 14");
//    }

    //Enable-System-Properties and Environment-Variable

    @Test
    @EnabledIfEnvironmentVariable(named = "SUMIT_ENV", matches = "DEV")
    public void testOnlyForDevEnvironment(){
        System.out.println("Test case for only Dev Environment");
        //Set env --> click on 3 dots and modify the run configuration and add environment variable
        //SUMIT_ENV = DEV
    }

    @Test
    @EnabledIfSystemProperty(named = "SUMIT_SYS", matches = "DEV")
    public void testOnlyForSystemProperty(){
        System.out.println("Test case for only System property");
        //Set env --> click on 3 dots and modify the run configuration and add system Properties
        //-D<propertykey>=<propertyValue> ex--> -DSUMIT_SYS=DEV
    }

}
