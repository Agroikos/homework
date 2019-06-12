package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.SumOfFirstHundred;
import junit.framework.TestCase;
import org.junit.Test;

public class SumOfFirstHundredTest extends TestCase {

    @Test
    public void testTheAlgo () {
        assertEquals(SumOfFirstHundred.calculateSumOfHundred(), 5050);
    }
}
