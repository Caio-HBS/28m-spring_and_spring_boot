package com.caiohbs.mockito.learnmockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl business;


    @Test
    void testSomeBusinessFindGreatestBasic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 13, 94});
        assertEquals(94, business.findGreatestInData());
    }

    @Test
    void testSomeBusinessFindGreatestSingleNumber() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{13});
        assertEquals(13, business.findGreatestInData());
    }

    @Test
    void testSomeBusinessFindGreatestNoNumbers() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, business.findGreatestInData());
    }

}

