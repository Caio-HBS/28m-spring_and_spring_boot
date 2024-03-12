package com.caiohbs.mockito.learnmockito.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

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
