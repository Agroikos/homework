package week4.hobbies;

import java.util.*;

public class Hobbies {
    public static void main(String[] args) {
        Map<Persoana, List<Hobby>> myPersonsHobbies = new HashMap<>();

        List<Hobby> personHobbies = Arrays.asList(
                new Hobby("skiing",10,
                        Arrays.asList(new Address("Romania"),
                        new Address("France"),
                        new Address("Germany"),
                        new Address("Switzerland"))),
                new Hobby("mountain biking",4,
                        Arrays.asList(new Address("Romania"),
                        new Address("France"),
                        new Address("Germany"),
                        new Address("Canada"))));
        myPersonsHobbies.put(new Persoana("John Smith", 36), personHobbies);

        personHobbies = Arrays.asList(
                new Hobby("skiing",8,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Switzerland"))),
                new Hobby("hang gliding",4,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Italy"))));
        myPersonsHobbies.put(new Persoana("Carrie Johnson", 29), personHobbies);

        personHobbies = Arrays.asList(
                new Hobby("swimming",3,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Bulgaria"),
                                new Address("Switzerland"))),
                new Hobby("mountain biking",4,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Mexico"))));
        myPersonsHobbies.put(new Persoana("Jake", 18), personHobbies);


        personHobbies = Arrays.asList(
                new Hobby("pie eating",7,
                        Arrays.asList(new Address("USA"),
                                new Address("France"),
                                new Address("Portugal"),
                                new Address("Switzerland"))),
                new Hobby("mountain biking",5,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Mexico"))));
        myPersonsHobbies.put(new Persoana("Lonnie Jackson", 36), personHobbies);

        personHobbies = Arrays.asList(
                new Hobby("playing music",10,
                        Arrays.asList(new Address("Romania"),
                                new Address("Italy"),
                                new Address("USA"),
                                new Address("Switzerland"),
                                new Address("Germany"),
                                new Address("UK"),
                                new Address("Mexico"))),
                new Hobby("mountain biking",8,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Mexico"))),
                new Hobby("knitting",5,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Mexico"),
                                new Address("Nepal"),
                                new Address("Sri Lanka"),
                                new Address("Georgia"),
                                new Address("Rwanda"))),
                new Hobby("painting",7,
                        Arrays.asList(new Address("Romania"),
                                new Address("France"),
                                new Address("Germany"),
                                new Address("Mexico"))));

        myPersonsHobbies.put(new Persoana("Cecilia Rodgers", 22), personHobbies);

        //for a certain Persoana, print the names of the hobbies and the countries where it can be practiced
        myPersonsHobbies.get(new Persoana("Cecilia Rodgers", 22)).stream().forEach(
                t -> {
                    System.out.print(t.getName() + ": ");
                    t.getAddresses().stream().forEach(x-> System.out.print(x.getCountry() + " "));
                    System.out.println();
                });
    }
}
