package week1;

import junit.framework.TestCase;

import org.junit.Test;

import week2.refactoredWeekTwo.Factorial;

public class FactorialTest extends TestCase {

    @Test
    public void testFactorialForFive () {
        assertEquals(120, Factorial.factorial(5));
    }
}
