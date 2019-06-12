package a_21_06.Test;

import a_21_06.RefactoredWeekTwo.MinimumFromArray;
import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumFromArrayTest extends TestCase {

    @Test
    public void testMinimumFromArray() {
        int[] testArray = {3,4,5,2,7,8,9};

        //assertEquals(3, MinimumFromArray.getMinFor(testArray, 7));

        assertEquals(2, MinimumFromArray.getMinFor(testArray,7));
    }
}
