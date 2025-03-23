package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("Acasa", LocationType.FRIENDLY),
                new Location("Facultate", LocationType.ENEMY),
                new Location("Parc", LocationType.NEUTRAL),
                new Location("Cantina", LocationType.FRIENDLY),
                new Location("Tramvai", LocationType.ENEMY)
        );


        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(location -> location.getType() == LocationType.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Friendly Locations (sorted by name):");
        friendlyLocations.forEach(System.out::println);

        LinkedList<Location> enemyLocations = locations.stream()
                .filter(location -> location.getType() == LocationType.ENEMY)
                .sorted(Comparator.comparing(Location::getType).thenComparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("\nEnemy Locations (sorted by type then name):");
        enemyLocations.forEach(System.out::println);
    }
}