package com.caiohbs.mockito.learnmockito.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public int findGreatestInData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;

        for (int value : data) {
            if (value > greatestValue) {
                greatestValue = value;
            }
        }
        return greatestValue;
    }

}

interface DataService {

    int[] retrieveAllData();

}
