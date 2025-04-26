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

    @Test
    public void testArraySort_NullArray_1(){
        int[] numbers = null;
        try{
            Arrays.sort(numbers);
        }
        catch (NullPointerException e){
        }
    }

    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray_2(){
        int[] numbers = null;
            Arrays.sort(numbers);
    }

    @Test(timeout = 100)
    public void testSort_Performance(){
        int array[] = {12,33,4};
        for(int i=1;i<1000000;i++){
            array[0] = i;
            Arrays.sort(array);
        }

    }

}
