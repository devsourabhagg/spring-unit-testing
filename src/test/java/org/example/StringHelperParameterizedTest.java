package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {


    StringHelper helper = new StringHelper();

    private String input;

    private String expectedOutput;


    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions(){
        String expectedOutputs[][] = {
                {"AACD","CD"},
                {"ACD","CD"}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Positions(){
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));

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
