import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Aircraft> aircrafts = Arrays.asList(
                new Airliner("Boeing 737", 101, "737-800", 180),
                new Airliner("Airbus A320", 102, "A320", 160),
                new Freighter("Cargolux 747", 201, "747-400F", 112000),
                new Freighter("Antonov An-124", 202, "An-124", 120000),
                new Drone("DJI Cargo", 301, "DJI Phantom", 10.5)
        );

        List<Aircraft> cargoAircrafts = new ArrayList<>();
        for (Aircraft a : aircrafts) {
            if (a instanceof CargoCapable) {
                cargoAircrafts.add(a);
            }
        }

        System.out.println("Aircrafts that can transport cargo:");
        for (Aircraft a : cargoAircrafts) {
            System.out.println(a);
        }
        System.out.println();

        List<Runway> runways = Arrays.asList(
                new Runway("Runway 1", true),
                new Runway("Runway 2", true)
        );
        Airport airport = new Airport(runways);

        List<Flight> flights = Arrays.asList(
                new Flight(airport, 101, LocalTime.of(10, 0), LocalTime.of(10, 30)), 
                new Flight(airport, 102, LocalTime.of(10, 15), LocalTime.of(10, 45)), 
                new Flight(airport, 103, LocalTime.of(10, 50), LocalTime.of(11, 20)), 
                new Flight(airport, 104, LocalTime.of(11, 0), LocalTime.of(11, 30)), 
                new Flight(airport, 105, LocalTime.of(11, 10), LocalTime.of(11, 40)), 
                new Flight(airport, 106, LocalTime.of(11, 45), LocalTime.of(12, 15))  
        );

        FlightSchedulerBalanced scheduler = new FlightSchedulerBalanced(airport, flights);
        Map<Flight, Runway> assignments = scheduler.scheduleFlightsEquitably();

        System.out.println("🛩️ Flight assignments (Balanced):");
        for (Map.Entry<Flight, Runway> entry : assignments.entrySet()) {
            System.out.println("Flight " + entry.getKey().getTailNumber() + " assigned to " + entry.getValue().getRunwaysName());
        }

        int minRunwaysNeeded = scheduler.determineMinRunwaysNeeded();
        System.out.println("\n🛩️ Minimum runways needed: " + minRunwaysNeeded);
    }
}
