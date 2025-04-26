package org.example;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringHelperTest {


    @Test
    public void testTruncateAInFirst2Positions(){
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));

    }
    //ABCD -> false, ABAB -> true, AB -> true, A -> false;
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario_1(){
        StringHelper helper = new StringHelper();
        boolean actaul = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
        boolean expected = false;
        assertEquals(expected,actaul);
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario_2(){
        StringHelper helper = new StringHelper();
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
        StringHelper helper = new StringHelper();
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

}
