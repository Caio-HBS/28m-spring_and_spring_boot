package com.caiohbs;

import org.caiohbs.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    private final MyMath math = new MyMath();

    @Test
    void testCalcSumWithThreeElements() {
        assertEquals(6, math.calcSum(new int[] {1, 2, 3}));
    }

    @Test
    void testCalcSumNoElements() {
        assertEquals(0, math.calcSum(new int[] {}));
    }

    @Test
    void testCalcSumNegativeNumbers() {
        assertEquals(-45, math.calcSum(new int[] {-1, -10, -34}));
    }

    @Test
    void testCalcSumSingleElement() {
        assertEquals(54, math.calcSum(new int[] {54}));
    }

}
