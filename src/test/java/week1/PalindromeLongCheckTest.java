package week1;

import junit.framework.TestCase;

import org.junit.Test;

import week2.RefactoredWeekTwo.PalindromeLongCheck;

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
