package com.caiohbs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("Make food", "Learn to code", "Learn Java");
    int[] numbersArray = {1, 2, 3};

    @Test
    void testTrueBooleanAssertion() {
        boolean test = todos.contains("Make food");
        assertTrue(test, "The todo is not on the list.");
    }

    @Test
    void testFalseBooleanAssertion() {
        boolean test = todos.contains("Order food");
        assertFalse(test, "The todo is on the list.");
    }

    @Test
    void testListSizeByNumbers() {
        assertEquals(3, todos.size(), "The list is not the size it should be.");
    }

    @Test
    void testArrays() {
        assertArrayEquals(new int[] {1, 2, 3}, numbersArray);
    }

}
