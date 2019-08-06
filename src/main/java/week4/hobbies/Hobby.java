package week4.hobbies;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Hobby {
    private String name;
    private int frequency; //number of times per week
    private List <Address> addresses = new ArrayList<>();
}
