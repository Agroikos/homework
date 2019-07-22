package assignment.model;

import junit.framework.TestCase;
import org.junit.Test;

public class TriangleTest extends TestCase {
    @Test
    public void testTrianglePerimeter() {
        assertEquals(12.0, new Triangle(3,4,5).getPerimeter());
    }

    @Test
    public void testTriangleSurfaceArea() {
        assertEquals(6.0, new Triangle(3,4,5).getSurfaceArea());
    }

    @Test
    public void testTriangleSurfaceAreaAnyNumbers() {
        assertEquals(0, Double.compare(7.806247497997997, new Triangle(4,4,5).getSurfaceArea()));
    }


}
