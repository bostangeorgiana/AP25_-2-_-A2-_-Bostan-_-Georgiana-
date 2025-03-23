import java.time.LocalTime;
import java.util.*;

public class Schedule {
    private Airport airport;
    private List<Flight> flights;

    public Schedule(Airport airport, List<Flight> flights) {
        this.airport = airport;
        this.flights = flights;
    }

    public Map<Flight, Runway> scheduleFlights() {

        // Sortam zborurile dupa ora de inceput
        Collections.sort(flights);

        Map<Flight, Runway> assignment = new HashMap<>();
        List<Runway> runways = airport.getRunways();
        Map<Runway, LocalTime> lastLandingTime = new HashMap<>();

        // Alocam zborurile pe piste
        for (Flight flight : flights) {
            boolean assigned = false;

            for (Runway runway : runways) {
                // Verificam daca pista e libera pentru acest zbor
                if (!lastLandingTime.containsKey(runway) ||
                        lastLandingTime.get(runway).isBefore(flight.getStartTime())) {

                    // Alocam zborul pe aceasta pista
                    assignment.put(flight, runway);
                    lastLandingTime.put(runway, flight.getEndTime());
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                System.out.println("Nu exista pista disponibila pentru " + flight.getTailNumber());
            }
        }

        return assignment;
    }



        }
