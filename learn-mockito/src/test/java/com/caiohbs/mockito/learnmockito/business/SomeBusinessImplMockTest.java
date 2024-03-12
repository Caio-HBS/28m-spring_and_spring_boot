package com.caiohbs.mockito.learnmockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    @Test
    void testSomeBusinessFindGreatest() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 13, 94});

        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);

        assertEquals(94, someBusiness.findGreatestInData());
    }

}

