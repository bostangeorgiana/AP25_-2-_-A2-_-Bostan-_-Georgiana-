import java.util.ArrayList;
import java.util.List;

public class Airport{
    private List<Airport> airports;  // Modificăm pentru a ține cont de mai multe aeroporturi
    private List<Flight> flights;
    private List<Runway> runways = new ArrayList<>();

    Airport(List<Runway> runways){
        this.runways=runways;
    }
    public List<Runway> getRunways() {
        return runways;
    }
}
