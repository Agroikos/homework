package assignment.model;

import junit.framework.TestCase;
import org.junit.Test;

public class RectangleTest extends TestCase {

    @Test
    public void testRectanglePerimeter() {
        assertEquals(14.0, new Rectangle(3,4).getPerimeter());
    }

    @Test
    public void testRectangleSurfaceArea() {
        assertEquals(12.0, new Rectangle(3,4).getSurfaceArea());
    }
}
