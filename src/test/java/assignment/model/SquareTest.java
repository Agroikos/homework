package assignment.model;

import junit.framework.TestCase;
import org.junit.Test;

public class SquareTest extends TestCase {
    @Test
    public void testSquarePerimeter() {
        assertEquals(12.0, new Square(3).getPerimeter());
    }

    @Test
    public void testSquareSurfaceArea() {
        assertEquals(9.0, new Square(3).getSurfaceArea());
    }
}
