

package org.example;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Location implements Comparable<Location> {
    String name;
    String secretName;
    LocationType type;

    Location (String name, LocationType type){
        this.name = name;
        this.type = type;

        Faker faker = new Faker();
        this.secretName = faker.name().firstName();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location location)) return false;
        return Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Location: \n" +
                "Name: " + name +
                "\nsecretName: " + secretName +
                "\nType: " + type;
    }
}
