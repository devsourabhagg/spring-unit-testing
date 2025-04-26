package org.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringHelperTest {


    StringHelper helper;

    @Before
    public void setUp(){
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions(){
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));

    }
    //ABCD -> false, ABAB -> true, AB -> true, A -> false;
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario_1(){
        boolean actaul = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
        boolean expected = false;
        assertEquals(expected,actaul);
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario_2(){
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

}
