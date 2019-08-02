package assignment.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Shape {
//not quite usefull, this info can be obtain from the object type (instanceOf)
    private ShapeTypes type;

    protected double getPerimeter() {
        System.out.println("Printing perimeter of shape " + type);
        return 0;
    }

    protected double getSurfaceArea () {
        System.out.println("Printing surface area of " + type);
        return 0;
    }

    //utility methods
    public ShapeTypes getType() {
        return type;
    }

    public void setType(ShapeTypes type) {
        this.type = type;
    }


    public abstract boolean equals (Shape shape);

    @Override
    public String toString() {
        return "Shape{" +
                "type=" + type +
                '}';
    }
}
