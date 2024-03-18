package com.caiohbs.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] retrieveData(boolean throwMe) {

        if (throwMe) {
            throw new RuntimeException("Something went wrong when trying to retrieve data.");
        }

        return new int[]{112, 243, 5, 1042};
    }

}
