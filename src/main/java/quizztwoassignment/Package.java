package quizztwoassignment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Package {
/*
For each package you need to have the following data:
- target location
- target distance in km
- package value
- delivery date
 */

    private String location;
    private int distance;
    private int value;
    private LocalDate date;

    public static int entryNum;


    public Package (String entry) {
        String[] elements = entry.split(",");

        //Apahida,15,249,2017-09-03

        if (elements.length != 4) System.out.println("entry data not correctly formatted");
        else {
            location = elements[0];
            distance = Integer.parseInt(elements[1]);
            value = Integer.parseInt(elements[2]);
            date = LocalDate.parse(elements[3]);

           /* System.out.println("Test: Package details # " + ++entryNum);
            System.out.println("Location: " + location);
            System.out.println("Distance: " + distance);
            System.out.println("Value: " + value);
            System.out.println("Date: " + date);
            System.out.println();
        */
        }
    }


}
