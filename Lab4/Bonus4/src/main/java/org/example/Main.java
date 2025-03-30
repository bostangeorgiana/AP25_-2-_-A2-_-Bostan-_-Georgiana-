package org.example;
import java.util.*;
import java.util.stream.Collectors;

import org.jgrapht.graph.DefaultEdge;


public class Main {
    public static void main(String[] args) {
        RandomProblemGenerator generator = new RandomProblemGenerator();
        List<Location> locations = generator.generateRandomLocations(10);

        StatisticsCalculator statsCalculator = new StatisticsCalculator();
        statsCalculator.calculateStatistics(locations);

        Map<Location, Map<Location, Double>> safetyMap = new HashMap<>();
        for (Location from : locations) {
            Map<Location, Double> toMap = new HashMap<>();
            for (Location to : locations) {
                if (!from.equals(to)) {
                    toMap.put(to, Math.random());
                }
            }
            safetyMap.put(from, toMap);
        }

        SafeRouteCalculator safeRouteCalculator = new SafeRouteCalculator(safetyMap);
        safeRouteCalculator.printSafeRoutes();
    }
}
