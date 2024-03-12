package com.caiohbs.mockito.learnmockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {

    @Test
    void testSomeBusinessFindGreatest() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);

        assertEquals(94, someBusiness.findGreatestInData());
    }

}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 13, 94};
    }
}
