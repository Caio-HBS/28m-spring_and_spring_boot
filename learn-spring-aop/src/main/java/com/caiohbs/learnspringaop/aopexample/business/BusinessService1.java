package com.caiohbs.learnspringaop.aopexample.business;

import com.caiohbs.learnspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateMax() {
        int[] data = dataService1.retrieveData(true);

        return Arrays.stream(data).max().orElse(0);

    }

}
