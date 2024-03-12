package com.caiohbs.mockito.learnmockito.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void testMockListSize() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);

        assertEquals(3, listMock.size());
    }

    @Test
    public void testMultipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(5);

        assertEquals(3, listMock.size());
        assertEquals(5, listMock.size());
        assertEquals(5, listMock.size());
    }

    @Test
    public void testMethodWithSpecificParameters() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("String");

        assertEquals("String", mockList.get(0));
        assertNull(mockList.get(1));
    }

    @Test
    public void testMethodWithGenericParameters() {
        List mockList = mock(List.class);
        when(mockList.get(Mockito.anyInt())).thenReturn("Some different string");

        assertEquals("Some different string", mockList.get(0));
        assertEquals("Some different string", mockList.get(200));
    }

}
