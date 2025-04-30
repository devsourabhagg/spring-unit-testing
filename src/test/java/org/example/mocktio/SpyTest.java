package org.example.mocktio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {


    @Test
    public void test_1(){
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0,arrayListSpy.size());
        //mock return default values
        arrayListSpy.add("dummy");
        assertEquals(1,arrayListSpy.size());
        arrayListSpy.remove("dummy");
    }

    @Test
    public void test_2(){
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0,arrayListSpy.size());
        //mock return default values
        arrayListSpy.add("dummy");
        verify(arrayListSpy).add("dummy");
        verify(arrayListSpy,never()).clear();
    }

}
