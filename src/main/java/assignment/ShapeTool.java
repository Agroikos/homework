package assignment;

import assignment.model.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static assignment.model.ShapeTypes.circle;
import static assignment.model.ShapeTypes.triangle;

public class ShapeTool {
    public static void main(String[] args) {

        MyShapes myShapes = new MyShapes();

        myShapes.add(new Circle(3.2));
        myShapes.add(new Circle(3.4));
        myShapes.add(new Circle(2.5));
        myShapes.add(new Circle(10));
        myShapes.add(new Circle(10));

        myShapes.add(new Triangle (1,2,3));
        myShapes.add(new Triangle (3,4,5));
        myShapes.add(new Triangle (1,3,2));
        myShapes.add(new Triangle (3,2,1));


        myShapes.add(new Triangle (2,3,1));
        myShapes.add(new Triangle (5,3,4));


        myShapes.add(new Square(4));
        myShapes.add(new Square(.5));
        myShapes.add(new Square(4.89));
        myShapes.add(new Square(10.11));


        myShapes.add(new Rectangle(23,14.9));
        myShapes.add(new Rectangle(8,4.8));
        myShapes.add(new Rectangle(26,8));
        myShapes.add(new Rectangle(6,19));
        myShapes.add(new Rectangle(4.8,8));


        System.out.println();
        System.out.println();
        System.out.println("printing all the elements");
        myShapes.getMyShapes().stream().forEach(t -> System.out.println(t.toString() + " "));

        System.out.println();
        System.out.println("print all elements of a certain type: ");
        System.out.println("Triangle");
        myShapes.returnAllOfType(triangle).stream().forEach(t -> System.out.println(t));

        System.out.println("circle");
        myShapes.returnAllOfType(circle).stream().forEach(t -> System.out.println(t));

        Map<Integer, Shape> lht = new HashMap();
        //lht.

    }
}
