package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.Factorial;
import junit.framework.TestCase;
import org.junit.Test;

public class FactorialTest extends TestCase {

    @Test
    public void testFactorialForFive () {
        assertEquals(120, Factorial.factorial(5));
    }
}
