package week2.Test;

import week2.RefactoredWeekTwo.MaxDigit;
import junit.framework.TestCase;
import org.junit.Test;

public class MaxDigitTest extends TestCase {

    @Test
    public void testMaxDigit () {
        assertEquals(9, MaxDigit.getMaxDigit(1247901215));
    }

}