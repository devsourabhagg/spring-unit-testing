package org.example.mocktio;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class HamcrestMatchersTest {


    @Test
    public void test(){
        List<Integer> scroes = Arrays.asList(99,100,101,105);
        //scores has 4 items
        assertThat(scroes,hasSize(4));
        assertThat(scroes,hasItems(99,100));

        // every item : > 90
        assertThat(scroes,everyItem(greaterThan(90)));
        assertThat(scroes,everyItem(lessThan(200)));

        //String
        assertThat("",isEmptyString());
        assertThat("",isEmptyOrNullString());

        //Arrays
        Integer[] marks = {1,2,3};
        assertThat(marks,arrayWithSize(3));
        assertThat(marks,arrayContaining(1,2,3));
        assertThat(marks,arrayContainingInAnyOrder(2,1,3));
    }
}
