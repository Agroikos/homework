package assignment.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static assignment.model.ShapeTypes.circle;

//why don't these annotations work?
@Getter
@Setter
@EqualsAndHashCode
public class Circle extends Shape  {
    private double radius;

    public Circle () {
        this.setType(circle);
    }

    public Circle (double radius) {
        this.setType(circle);
        this.radius = radius;
    }

    @Override
    public double getPerimeter () {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getSurfaceArea () {
        return Math.PI * this.radius * this.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals (Shape shape) {

        if (shape.getType() == circle)
            if (( (Circle) shape).getRadius() == this.radius) return true;

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
