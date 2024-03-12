package com.caiohbs;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("This runs only one time BEFORE ALL the tests.");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("\nThis runs BEFORE each method.");
    }

    @Test
    void test1() {
        System.out.println("---FIRST TEST---");
    }

    @Test
    void test2() {
        System.out.println("---SECOND TEST---");
    }

    @Test
    void test3() {
        System.out.println("---THIRD TEST---");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("This runs AFTER each method.");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("\n\nThis runs only one time AFTER ALL the tests:\n\"We are human\nAfter all\nMuch in common\nAfter all.\"");
    }

}
