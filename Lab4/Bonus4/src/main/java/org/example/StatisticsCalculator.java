package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsCalculator {

    public void calculateStatistics(List<Location> locations) {
        Map<LocationType, Long> stats = locations.stream()
                .collect(Collectors.groupingBy(Location::getType, Collectors.counting()));

        System.out.println("Numarul de locatii de fiecare tip:");
        stats.forEach((type, count) -> System.out.println(type + ": " + count));
    }
}

