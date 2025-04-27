package org.example.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void testMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }

    @Test
    public void testMockListGet(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Sourabh");
        assertEquals("Sourabh",listMock.get(0));
    }

    @Test
    public void testMockListGet_argumentMatchers(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Sourabh");
        assertEquals("Sourabh",listMock.get(0));
        assertEquals("Sourabh",listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testMockList_throwAnException_wrong(){
        List listMock = mock(List.class);
        //this is wrong exception should be thrown here not in return
        when(listMock.get(anyInt())).thenReturn(new RuntimeException("Something"));
        listMock.get(0);
    }
    @Test(expected = RuntimeException.class)
    public void testMockList_throwAnException(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void testMockList_mixingUp(){
        List listMock = mock(List.class);
        when(listMock.subList(anyInt(),6)).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }

    @Test
    public void testMockListGet_argumentMatchers_usingBDD(){
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("Sourabh");

        //When
        String firstElement = listMock.get(0);

        //Then
        assertThat(firstElement,is("Sourabh"));
    }
}
