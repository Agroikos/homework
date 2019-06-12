package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.PalindromeLongCheck;
import junit.framework.TestCase;
import org.junit.Test;

public class PalindromeLongCheckTest extends TestCase {

    @Test
    public void testPalindromity () {
        assertTrue(PalindromeLongCheck.checkPalindromeNoArray(123454321));
    }

    @Test
    public void testNonPalindromity () {
        assertFalse(PalindromeLongCheck.checkPalindromeNoArray(1234564321));
    }
}
