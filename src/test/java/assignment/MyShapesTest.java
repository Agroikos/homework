package assignment;

import assignment.model.*;
import junit.framework.TestCase;
import org.junit.Test;

import static assignment.model.ShapeTypes.*;

public class MyShapesTest extends TestCase {
    @Test
    public void testAddNoDuplicates() {
        MyShapes myShapes = new MyShapes();

        myShapes.add(new Triangle(1,2,3));
        myShapes.add(new Triangle(3,1,2));

        assertEquals(1, myShapes.getMyShapes().size());

    }

    @Test
    public void testAddNoDuplicatesSeveralTypes() {
        MyShapes myShapes = new MyShapes();

        myShapes.add(new Triangle(1,2,3));
        myShapes.add(new Triangle(3,1,2));
        myShapes.add(new Rectangle(8,4.8));
        myShapes.add(new Rectangle(26,8));
        myShapes.add(new Rectangle(8,4.8));

        assertEquals(3, myShapes.getMyShapes().size());

    }


    public void testAddDifferentTypeElements () {
        MyShapes myShapes = new MyShapes();

        myShapes.add(new Triangle(10,24,35));
        myShapes.add(new Circle(2.5));

        myShapes.add(new Triangle(1,2,3));
        myShapes.add(new Triangle(4,5,3));
        myShapes.add(new Triangle(10,24,35));
        myShapes.add(new Triangle(5,2,7));

        myShapes.add(new Circle(3.2));
        myShapes.add(new Circle(3.4));
        myShapes.add(new Circle(2.5));

        assertEquals(4, myShapes.returnAllOfType(triangle).size());
    }

    public void testAddManyDifferentTypeElements () {
        MyShapes myShapes = new MyShapes();

        myShapes.add(new Circle(3.2));
        myShapes.add(new Circle(3.4));
        myShapes.add(new Circle(2.5));
        myShapes.add(new Circle(10));

        myShapes.add(new Triangle (1,2,3));
        myShapes.add(new Triangle (3,4,5));
        myShapes.add(new Triangle(10,24,35));
        myShapes.add(new Triangle(5,2,7));

        myShapes.add(new Square(4));
        myShapes.add(new Square(.5));
        myShapes.add(new Square(4.89));
        myShapes.add(new Square(10.11));


        myShapes.add(new Rectangle(23,14.9));
        myShapes.add(new Rectangle(8,4.8));
        myShapes.add(new Rectangle(26,8));
        myShapes.add(new Rectangle(6,19));

        assertEquals(4, myShapes.returnAllOfType(triangle).size());
        assertEquals(16, myShapes.getMyShapes().size());
    }

    @Test
    public void testPerimeterSum() {
        MyShapes myShapes = new MyShapes();

        myShapes.add(new Triangle(1,2,3));
        myShapes.add(new Triangle(4,5,3));
        myShapes.add(new Triangle(10,24,35));
        myShapes.add(new Triangle(5,2,7));
        myShapes.add(new Circle(3.2));
        myShapes.add(new Circle(3.4));
        myShapes.add(new Circle(2.5));

        myShapes.add(new Triangle(7,2,5));

        assertEquals(101.0, myShapes.sumOfPerimeters(triangle));
    }
}
