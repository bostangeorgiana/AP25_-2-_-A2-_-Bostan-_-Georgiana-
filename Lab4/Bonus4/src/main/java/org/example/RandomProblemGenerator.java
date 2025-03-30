package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class RandomProblemGenerator {

    private Faker faker = new Faker();

    public Location generateRandomLocation(LocationType type) {
        String name = faker.address().city();
        double safetyProbability = Math.random();
        return new Location(name, type, safetyProbability);
    }

    public List<Location> generateRandomLocations(int numLocations) {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < numLocations; i++) {
            LocationType type = LocationType.values()[(int) (Math.random() * LocationType.values().length)];
            locations.add(generateRandomLocation(type));
        }
        return locations;
    }
}

