package week4.hobbies;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String streetAddress;
    private String country;

    Address(String country) {
        this.country = country;
    }
}
