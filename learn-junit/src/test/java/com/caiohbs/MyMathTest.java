package com.caiohbs;

import org.caiohbs.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    @Test
    void test() {
        MyMath math = new MyMath();
        int[] randomNums = {1, 2, 3};

        int result = math.calcSum(randomNums);
        int expectedResult = 6;

        assertEquals(expectedResult, result);
    }

}
