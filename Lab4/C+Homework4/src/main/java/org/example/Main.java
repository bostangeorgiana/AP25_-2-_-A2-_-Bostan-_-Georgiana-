package org.example;
import java.util.*;
import java.util.stream.Collectors;

import org.jgrapht.graph.DefaultEdge;


public class Main {
    public static void main(String[] args) {
        // creem locatii
        Location loc1 = new Location("City A", LocationType.FRIENDLY);
        Location loc2 = new Location("City B", LocationType.ENEMY);
        Location loc3 = new Location("City C", LocationType.NEUTRAL);
        Location loc4 = new Location("City D", LocationType.FRIENDLY);

        // Adăugăm locațiile într-o listă
        List<Location> locations = Arrays.asList(loc1, loc2, loc3, loc4);

        // Mapa cu timpi între locații
        Map<Location, Map<Location, Integer>> timeMap = new HashMap<>();

        // Exemplu de timpi între locații (poți să adaugi mai mulți timpi aici)
        Map<Location, Integer> fromLoc1 = new HashMap<>();
        fromLoc1.put(loc2, 5); // Timpul de la loc1 la loc2 este 5 minute
        fromLoc1.put(loc3, 10);
        timeMap.put(loc1, fromLoc1);

        Map<Location, Integer> fromLoc2 = new HashMap<>();
        fromLoc2.put(loc4, 7);
        timeMap.put(loc2, fromLoc2);

        Map<Location, Integer> fromLoc3 = new HashMap<>();
        fromLoc3.put(loc1, 4);
        timeMap.put(loc3, fromLoc3);

        Map<Location, Integer> fromLoc4 = new HashMap<>();
        fromLoc4.put(loc1, 3);
        timeMap.put(loc4, fromLoc4);

        // Creăm procesorul de locații
        LocationProcessor processor = new LocationProcessor(locations, timeMap);

        // Afișăm timpii
        processor.printShortestTimes(loc1);  // Afișează timpii începând de la loc1
    }
}
