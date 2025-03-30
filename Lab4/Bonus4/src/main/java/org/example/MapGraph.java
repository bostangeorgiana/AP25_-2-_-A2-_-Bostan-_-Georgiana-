package org.example;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.Map;

public class MapGraph
{
    Graph<Location, DefaultWeightedEdge> graph;
    Map<Location, Integer> shortestTimes;
    /* (comentarii pt mine)
    * WeightedMultigraph<> - o clasa din biblioteca JGraphT - reprezinta un graf ponderat
    *  Nodurile  sunt obiecte de un anumit tip
    *  Muchiile au greutati asociate (asta este ceea ce ne intereseaza pe noi)
     * !! Permite mai multe muchii intre aceleași doua noduri
    * */

    public MapGraph() {
        graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        shortestTimes = new HashMap<>();
    }

    public void addLocation(Location location) {
        graph.addVertex(location);
    }

    public void addEdge(Location from, Location to, int time) {
        DefaultWeightedEdge edge = graph.addEdge(from, to);
        graph.setEdgeWeight(edge, time);
    }

    public void findFastestRoutes(Location startLocation) {
        var dijkstra = new org.jgrapht.alg.shortestpath.DijkstraShortestPath<>(graph);
        /* (comentarii pt mine)
        *  DijkstraShortestPath<> - o clasa din biblioteca JGraphT
        * Face parte din pachetul org.jgrapht.alg.shortestpath (acesta contine alg. pentru cele mai scurte drumuri)
        * */

        for (Location location : graph.vertexSet()) {
            var path = dijkstra.getPath(startLocation, location);
            if (path != null) {
                shortestTimes.put(location, (int) path.getWeight());
            }
        }
    }

    public void printFastestTimes() {
        shortestTimes.forEach((location, time) ->
                System.out.println("Locatia: " + location.getName() + " - Timpul cel mai scurt: " + time + " secunde")
        );
    }
}
