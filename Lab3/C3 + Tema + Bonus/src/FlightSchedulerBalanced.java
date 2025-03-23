import java.time.LocalTime;
import java.util.*;
public class FlightSchedulerBalanced {
    private Airport airport;
    private List<Flight> flights;

    public FlightSchedulerBalanced(Airport airport, List<Flight> flights) {
        this.airport = airport;
        this.flights = new ArrayList<>(flights);
    }


    public Map<Flight, Runway> scheduleFlightsEquitably() {
        // Sortam zborurile dupa timpul de start
        Collections.sort(flights);

        Map<Flight, Runway> assignments = new HashMap<>();
        PriorityQueue<Runway> availableRunways = new PriorityQueue<>(Comparator.comparingInt(this::countFlightsOnRunway));

        availableRunways.addAll(airport.getRunways());

        for (Flight flight : flights) {
            Runway bestRunway = availableRunways.poll(); // Luam pista cu cele mai putine zboruri
            assignments.put(flight, bestRunway);
            availableRunways.offer(bestRunway);
        }

        return assignments;
    }

    private int countFlightsOnRunway(Runway runway) {
        return (int) flights.stream()
                .filter(flight -> flight.getLandingInterval() != null && flight.getStartTime() != null)
                .filter(flight -> flight.getLandingInterval().equals(runway))
                .count();
    }

    public int determineMinRunwaysNeeded() {
        // Sortam zborurile dupa ora de sosire
        List<LocalTime> startTimes = new ArrayList<>();
        List<LocalTime> endTimes = new ArrayList<>();

        for (Flight flight : flights) {
            startTimes.add(flight.getStartTime());
            endTimes.add(flight.getEndTime());
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int maxRunwaysNeeded = 0, currentRunways = 0;
        int i = 0, j = 0;

        while (i < startTimes.size() && j < endTimes.size()) {
            if (startTimes.get(i).isBefore(endTimes.get(j))) {
                currentRunways++;
                maxRunwaysNeeded = Math.max(maxRunwaysNeeded, currentRunways);
                i++;
            } else {
                currentRunways--;
                j++;
            }
        }

        return maxRunwaysNeeded;
    }

}
