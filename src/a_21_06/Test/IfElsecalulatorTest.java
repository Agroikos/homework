package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.IfElseCalculator;

import junit.framework.TestCase;
import org.junit.Test;

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
