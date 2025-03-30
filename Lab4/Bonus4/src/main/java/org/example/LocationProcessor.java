package org.example;
import java.util.*;

import org.example.Location;
import org.example.LocationType;

import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class LocationProcessor {

    private List<Location> locations;
    private Map<Location, Map<Location, Integer>> timeMap;

    /*
    *  DefaultEdge - o clasa predefinita in JGraphT
    *  Reprezinta o muchie simpla

    * timeMap.get(from) + containsKey(to) -> verificam daca exista cheia to asociata lui from

    * */

    public LocationProcessor(List<Location> locations, Map<Location, Map<Location, Integer>> timeMap) {
        this.locations = locations;
        this.timeMap = timeMap;
    }

    public Graph<Location, DefaultEdge> createGraph() {
        Graph<Location, DefaultEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultEdge.class);

        for (Location location : locations) {
            graph.addVertex(location);
        }

        for (Location from : locations) {
            for (Location to : locations) {
                if (timeMap.containsKey(from) && timeMap.get(from).containsKey(to)) {
                    graph.addEdge(from, to);
                    graph.setEdgeWeight(graph.getEdge(from, to), timeMap.get(from).get(to));
                }
            }
        }

        return graph;
    }

    public Map<Location, Integer> calculateShortestTimes(Location startLocation) {
        Graph<Location, DefaultEdge> graph = createGraph();
        DijkstraShortestPath<Location, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);

        Map<Location, Integer> shortestTimes = new HashMap<>();
        for (Location location : locations) {
            var path = dijkstraAlg.getPath(startLocation, location);
            if (path != null) {
                shortestTimes.put(location, (int) path.getWeight());
            } else {
                shortestTimes.put(location, Integer.MAX_VALUE);
            }
        }

        return shortestTimes;
    }


    public void printShortestTimes(Location startLocation) {
        Map<Location, Integer> shortestTimes = calculateShortestTimes(startLocation);

        Map<LocationType, List<Location>> groupedLocations = locations.stream()
                .collect(Collectors.groupingBy(Location::getType));

        System.out.println("Pentru locatiile friendly:");
        groupedLocations.get(LocationType.FRIENDLY).forEach(location -> {
            int time = shortestTimes.getOrDefault(location, Integer.MAX_VALUE);
            System.out.println(location.getName() + ": " + time + " minute");
        });

        System.out.println("\nPentru locatiile neutral:");
        groupedLocations.get(LocationType.NEUTRAL).forEach(location -> {
            int time = shortestTimes.getOrDefault(location, Integer.MAX_VALUE);
            System.out.println(location.getName() + ": " + time + " minute");
        });

        System.out.println("\nPentru locatiile enemy:");
        groupedLocations.get(LocationType.ENEMY).forEach(location -> {
            int time = shortestTimes.getOrDefault(location, Integer.MAX_VALUE);
            System.out.println(location.getName() + ": " + time + " minute");
        });
    }
}
