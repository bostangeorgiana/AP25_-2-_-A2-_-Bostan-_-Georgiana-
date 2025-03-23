import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 🛩️ Creăm aeronave diferite
        List<Aircraft> aircrafts = Arrays.asList(
                new Airliner("Boeing 737", 101, "737-800", 180),
                new Airliner("Airbus A320", 102, "A320", 160),
                new Freighter("Cargolux 747", 201, "747-400F", 112000),
                new Freighter("Antonov An-124", 202, "An-124", 120000),
                new Drone("DJI Cargo", 301, "DJI Phantom", 10.5)
        );

        // 🛩️ Selectăm aeronavele care pot transporta marfă
        List<Aircraft> cargoAircrafts = new ArrayList<>();
        for (Aircraft a : aircrafts) {
            if (a instanceof CargoCapable) {
                cargoAircrafts.add(a);
            }
        }

        System.out.println("📦 Aircrafts that can transport cargo:");
        for (Aircraft a : cargoAircrafts) {
            System.out.println(a);
        }
        System.out.println();

        // 🛩️ Creăm un aeroport cu piste
        List<Runway> runways = Arrays.asList(
                new Runway("Runway 1", true),
                new Runway("Runway 2", true)
        );
        Airport airport = new Airport(runways);

        // 🛩️ Creăm zboruri (Flight)
        List<Flight> flights = Arrays.asList(
                new Flight(airport, 101, LocalTime.of(10, 0), LocalTime.of(10, 30)), // Boeing 737
                new Flight(airport, 102, LocalTime.of(10, 15), LocalTime.of(10, 45)), // Airbus A320
                new Flight(airport, 103, LocalTime.of(10, 50), LocalTime.of(11, 20)), // Cargolux 747
                new Flight(airport, 104, LocalTime.of(11, 0), LocalTime.of(11, 30)), // Antonov An-124
                new Flight(airport, 105, LocalTime.of(11, 10), LocalTime.of(11, 40)), // DJI Cargo
                new Flight(airport, 106, LocalTime.of(11, 45), LocalTime.of(12, 15))  // Another flight
        );

        // 🛩️ Programăm zborurile folosind algoritmul echitabil
        FlightSchedulerBalanced scheduler = new FlightSchedulerBalanced(airport, flights);
        Map<Flight, Runway> assignments = scheduler.scheduleFlightsEquitably();

        // 🛩️ Afișăm rezultatele alocării pistelor
        System.out.println("🛩️ Flight assignments (Balanced):");
        for (Map.Entry<Flight, Runway> entry : assignments.entrySet()) {
            System.out.println("Flight " + entry.getKey().getTailNumber() + " assigned to " + entry.getValue().getRunwaysName());
        }

        // 🛩️ Verificăm numărul minim de piste necesare
        int minRunwaysNeeded = scheduler.determineMinRunwaysNeeded();
        System.out.println("\n🛩️ Minimum runways needed: " + minRunwaysNeeded);
    }
}
