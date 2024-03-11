package org.caiohbs;

public class MyMath {

    public int calcSum(int[] numbers) {
        int totalSum = 0;
        for (int number : numbers) {
            totalSum += number;
        }
        return totalSum;
    }

}
