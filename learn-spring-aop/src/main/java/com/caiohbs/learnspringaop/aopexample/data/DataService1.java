package com.caiohbs.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[] {11, 23, 55, 102};
    }

}
