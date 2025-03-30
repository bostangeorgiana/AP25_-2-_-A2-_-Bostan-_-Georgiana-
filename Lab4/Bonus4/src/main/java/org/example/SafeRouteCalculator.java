package org.example;

import java.util.Map;

public class SafeRouteCalculator {
    private Map<Location, Map<Location, Double>> safetyMap;

    public SafeRouteCalculator(Map<Location, Map<Location, Double>> safetyMap) {
        this.safetyMap = safetyMap;
    }

    public void calculateSafestRoutes(Location startLocation) {
        safetyMap.forEach((from, toMap) -> {
            toMap.forEach((to, probability) -> {
                System.out.println("Ruta de la " + from.getName() + " la " + to.getName() +
                        " are probabilitatea de siguranta: " + probability);
            });
        });
    }

    public void printSafeRoutes() {
        safetyMap.forEach((from, toMap) -> {
            toMap.forEach((to, probability) -> {
                if (probability > 0.8) {
                    System.out.println("Ruta sigura: " + from.getName() + " -> " + to.getName() + " cu probabilitate: " + probability);
                }
            });
        });
    }
}
