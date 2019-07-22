package assignment.model;

import junit.framework.TestCase;
import org.junit.Test;


public class CircleTest extends TestCase {
    @Test
    public void testCirclePerimeter() {
        assertEquals( 0, Double.compare(18.84955592153876, new Circle(3).getPerimeter()));
    }

    @Test
    public void testCircleSurfaceArea() {
        assertEquals(0, Double.compare(28.274333882308138, new Circle(3).getSurfaceArea()));
    }
}
