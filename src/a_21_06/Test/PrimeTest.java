package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.PrimeNumsLower;
import junit.framework.TestCase;
import org.junit.Test;

public class PrimeTest extends TestCase {

    @Test
    public void testPrimeness () {
        assertTrue(PrimeNumsLower.checkPrime(953));
    }

    @Test
    public void testNonPrimeness () {
        assertFalse(PrimeNumsLower.checkPrime(946));
    }
}
