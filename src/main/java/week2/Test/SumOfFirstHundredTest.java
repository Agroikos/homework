package week2.Test;

import week2.RefactoredWeekTwo.SumOfFirstHundred;
import junit.framework.TestCase;
import org.junit.Test;

public class SumOfFirstHundredTest extends TestCase {

    @Test
    public void testTheAlgo () {
        assertEquals(SumOfFirstHundred.calculateSumOfHundred(), 5050);
    }
}
