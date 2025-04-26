package org.example;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ArraysCompareTest {

    //Arrays.sort
    @Test
    public void testArraySort_RandomArray(){
        int[] numbers = {12,3,4,1};
        int[] expected = {1,5,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
        //arrays first differed at element [1];
        //Expected :5
        //Actual   :3
    }
}
