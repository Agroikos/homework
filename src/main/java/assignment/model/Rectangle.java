package assignment.model;

import java.util.Objects;

import static assignment.model.ShapeTypes.rectangle;

public class Rectangle extends Shape {
    private double sideA, sideB;

    public Rectangle () {
        super(rectangle);
    }

    public Rectangle (double sideA, double sideB) {
        super(rectangle);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getPerimeter () {
        return 2*(sideA + sideB);
    }

    @Override
    public double getSurfaceArea() {
        return sideA * sideB;
    }

    @Override
    public boolean equals (Shape shape) {

        //if (shape instanceof Rectangle)
        //or
        if (shape.getType() == rectangle)
            if ( (( (Rectangle) shape).getSideA() == this.sideA) && ( (Rectangle) shape).getSideB() == this.sideB)
                return true;
            else if (( (Rectangle) shape).getSideA() == this.sideB && ( (Rectangle) shape).getSideB() == this.sideA)
                return true;

        return false;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }


    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
