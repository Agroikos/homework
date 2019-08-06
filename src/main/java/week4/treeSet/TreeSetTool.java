package week4.treeSet;

import week4.treeSet.entity.Persoana;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTool {
    public static void main(String[] args) {

        Comparator<Persoana> sortByName = new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Persoana> sortByAge = new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Set<Persoana> personsByAge = new TreeSet<>(sortByAge);

        personsByAge.add(new Persoana("Mike", 32));
        personsByAge.add(new Persoana("Joe", 12));
        personsByAge.add(new Persoana("Jimmy", 27));
        personsByAge.add(new Persoana("Sam", 50));
        personsByAge.add(new Persoana("Alice", 18));
        personsByAge.add(new Persoana("Joan", 29));
        personsByAge.add(new Persoana("Annie", 14));

        System.out.println("My set, ordered by age is:");
        personsByAge.stream().forEach(t -> System.out.println(t + " "));



        Set<Persoana> personsByName = new TreeSet<>(sortByName);
        personsByName.add(new Persoana("Mike", 32));
        personsByName.add(new Persoana("Joe", 12));
        personsByName.add(new Persoana("Jimmy", 27));
        personsByName.add(new Persoana("Sam", 50));
        personsByName.add(new Persoana("Alice", 18));
        personsByName.add(new Persoana("Joan", 29));
        personsByName.add(new Persoana("Annie", 14));


        System.out.println("My set, ordered by name is:");
        personsByName.stream().forEach(t -> System.out.println(t + " "));

    }
}

class SortByName implements Comparator<Persoana> {

    @Override
    public int compare(Persoana o1, Persoana o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class SortByAge implements Comparator<Persoana> {

    @Override
    public int compare(Persoana o1, Persoana o2) {
        return Math.round(o1.getAge() - o2.getAge());
    }
}