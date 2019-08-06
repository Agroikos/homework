package week1;

import junit.framework.TestCase;

import org.junit.Test;

import week2.refactoredWeekTwo.SumOfFirstHundred;

public class SumOfFirstHundredTest extends TestCase {

    @Test
    public void testTheAlgo () {
        assertEquals(SumOfFirstHundred.calculateSumOfHundred(), 5050);
    }
}
