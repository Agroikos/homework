package assignment.model;

import java.util.Objects;

//Lombok nu a mers. Pare sa nu faca nimic

import static assignment.model.ShapeTypes.triangle;

public class Triangle extends Shape {
    private double sideA, sideB, sideC;

    public Triangle() {
        this.setType(triangle);
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.setType(triangle);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter () {
        return sideA + sideB + sideC;
    }

    @Override
    public double getSurfaceArea() {

        //calculate area from side lengths using Heron's formula

        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt(halfPerimeter *
                (halfPerimeter - sideA) *
                (halfPerimeter - sideB) *
                (halfPerimeter - sideC));
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

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }


    @Override
    public boolean equals (Shape shape) {

        //if (shape instanceof Square)
        //or
        if (shape.getType() == triangle) {
            if (((Triangle) shape).getSideA() == this.sideA) {
                if (((Triangle) shape).getSideB() == this.sideB && ((Triangle) shape).getSideC() == this.sideC)
                    return true;
                if (((Triangle) shape).getSideB() == this.sideC && ((Triangle) shape).getSideC() == this.sideB)
                    return true;
            }

            if (((Triangle) shape).getSideA() == this.sideB) {
                if (((Triangle) shape).getSideB() == this.sideA && ((Triangle) shape).getSideC() == this.sideC)
                    return true;
                if (((Triangle) shape).getSideB() == this.sideC && ((Triangle) shape).getSideC() == this.sideA)
                    return true;
            }

            if (((Triangle) shape).getSideA() == this.sideC) {
                if (((Triangle) shape).getSideB() == this.sideB && ((Triangle) shape).getSideC() == this.sideA)
                    return true;
                if (((Triangle) shape).getSideB() == this.sideA && ((Triangle) shape).getSideC() == this.sideB)
                    return true;
            }

        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
