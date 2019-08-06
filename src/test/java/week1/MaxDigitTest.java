package week1;

import junit.framework.TestCase;

import org.junit.Test;

import week2.refactoredWeekTwo.MaxDigit;

public class MaxDigitTest extends TestCase {

    @Test
    public void testMaxDigit () {
        assertEquals(9, MaxDigit.getMaxDigit(1247901215));
    }

}
