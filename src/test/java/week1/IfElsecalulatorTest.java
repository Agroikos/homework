package week1;

import junit.framework.TestCase;

import org.junit.Test;

import week2.refactoredWeekTwo.IfElseCalculator;

public class IfElsecalulatorTest extends TestCase {

    @Test
    public void testTwoMinusThree()
    {
        assertEquals(-1, IfElseCalculator.calculatorWReturn (2,3,"-"));
    }

    @Test
    public void testTenDividedByFive () {
        assertEquals(2, IfElseCalculator.calculatorWReturn(10,5,"/"));
    }

}
