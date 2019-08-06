package week4.hobbies;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Persoana {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;
        Persoana persoana = (Persoana) o;
        return age == persoana.age &&
                name.equals(persoana.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
