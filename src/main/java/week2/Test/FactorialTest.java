package week2.Test;

import week2.RefactoredWeekTwo.Factorial;
import junit.framework.TestCase;
import org.junit.Test;

public class FactorialTest extends TestCase {

    @Test
    public void testFactorialForFive () {
        assertEquals(120, Factorial.factorial(5));
    }
}
