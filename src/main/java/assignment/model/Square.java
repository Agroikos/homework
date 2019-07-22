package assignment.model;

import java.util.Objects;

import static assignment.model.ShapeTypes.square;

public class Square extends Shape {
    private double side;

    public Square() {
        this.setType(square);
    }

    public Square(double side) {
        this.setType(square);
        this.side = side;
    }

    @Override
    public double getPerimeter () {
        return 4*side;
    }

    @Override
    public double getSurfaceArea() {
        return side * side;
    }

    @Override
    public boolean equals (Shape shape) {

        //if (shape instanceof Square)
        //or
        if (shape.getType() == square)
            if (( (Square) shape).getSide() == this.side) return true;

        return false;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
