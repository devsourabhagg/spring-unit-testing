package org.example;

import org.junit.*;

public class QuickBeforeAfterTest {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @Before
    public void setUp(){
        System.out.println("Before Test");
    }

    @Test
    public void test1(){
        System.out.println("test 1 executed");
    }

    @Test
    public void test2(){
        System.out.println("test 2 executed");
    }

    @After
    public void tearDown(){
        System.out.println("After test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }

}
