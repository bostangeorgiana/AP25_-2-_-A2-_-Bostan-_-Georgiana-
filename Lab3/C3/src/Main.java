import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creare obiecte
        Airliner a1 = new Airliner("Boeing 737", 123123, "180", 120);
        Freighter f1 = new Freighter("Cargolux 747", 456456, "10000", 25);
        Drone d1 = new Drone("DJI Phantom", 546789, "5", 50);
        Airliner a2 = new Airliner("Airbus A320", 986999, "150", 120);
        Freighter f2 = new Freighter("Antonov An-124", 159654, "12000", 25);

        // Lista de aeronave
        List<Aircraft> aircraftList = new ArrayList<>();
        aircraftList.add(a1);
        aircraftList.add(f1);
        aircraftList.add(d1);
        aircraftList.add(a2);
        aircraftList.add(f2);

        // Afisare aeronave
        System.out.println("Toate aeronavele:");
        for (Aircraft a : aircraftList) {
            System.out.println(a);
        }

        // Lista cu aeronave care transporta marfa
        List<CargoCapable> cargoAircraft = new ArrayList<>();
        for (Aircraft a : aircraftList) {
            if (a instanceof CargoCapable) {
                cargoAircraft.add((CargoCapable) a);
            }
        }

        // Afisare aeronave de marfa
        System.out.println("\nAeronave care transporta marfa:");
        for (CargoCapable cargo : cargoAircraft) {
            System.out.println(cargo);
        }
    }
}
