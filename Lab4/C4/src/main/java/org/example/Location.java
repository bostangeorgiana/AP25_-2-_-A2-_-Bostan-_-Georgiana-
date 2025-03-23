package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

enum LocationType{
    FRIENDLY,
    NEUTRAL,
    ENEMY;
}

@Setter
@Getter
public class Location implements Comparable<Location> {
    String name;
    LocationType type;

    Location (String name, LocationType type){
        this.name = name;
        this.type = type;
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
}
