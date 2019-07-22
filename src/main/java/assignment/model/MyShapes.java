package assignment.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MyShapes {
    private Set<Shape> myShapes = new HashSet<>();

    public boolean add (Shape element) {

        if (!inSet(element)) {
            System.out.println("adding " + element.toString());
            myShapes.add(element);
            return true;
        }
        System.out.println("NOT adding: " + element.toString() + " It already exists in the list!");
        return false;
    }

    //am implementat eu manual verificarea ca elementul nu se afla deja in lista, pentru ca Set.add nu mi-a luat in calcul override-ul la metoda equals
    //Why? Cum se face corect?
    private boolean inSet(Shape element) {
        return this.myShapes.stream().anyMatch(t -> element.equals(t));
    }

    //alte metode asociate listei

    //arata toate elementele care apartin unui anumit tip
    public Set<Shape> returnAllOfType (ShapeTypes type) {
        return myShapes.stream().filter(t -> t.getType() == type).collect(Collectors.toSet());
    }

    public double sumOfPerimeters () {
        double sum = 0;
        for (Shape t : myShapes) sum += t.getPerimeter();

        return sum;
    }

    public double sumOfPerimeters (ShapeTypes type) {
        double sum = 0;
        for ( Shape t : myShapes)
            if (t.getType() == type) sum += t.getPerimeter();

        return sum;
    }

    public double sumOfSurfaceAreas () {
        double sum = 0;

        for (Shape t: myShapes) {sum += t.getSurfaceArea();}

        return sum;
    }

    public double sumOfSurfaceAreas(ShapeTypes type) {
        double sum = 0;

        for (Shape t: myShapes) {
            if (t.getType() == type) sum += t.getSurfaceArea();
        }
        return sum;
    }

    public long getNumberOf(ShapeTypes type) {
        return myShapes.stream().filter(t -> t.getType() == type).count();
    }

    public Set<Shape> getMyShapes() {
        return myShapes;
    }

    public void setMyShapes(Set<Shape> myShapes) {
        this.myShapes = myShapes;
    }

    @Override
    public String toString() {
        return "MyShapes{" +
                "myShapes=" + myShapes +
                '}';
    }
}
