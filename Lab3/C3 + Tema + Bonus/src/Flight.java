import java.time.LocalTime;

public class Flight implements Comparable<Flight>{
    private Airport airport;
    protected int tailNumber;
    private TimeInterval landingInterval; //intervalul de aterizare

    Flight(Airport airport, int tailNumber, LocalTime startTime, LocalTime endTime){
        this.airport = airport;
        this.tailNumber = tailNumber;
        this.landingInterval = new TimeInterval(startTime, endTime);
    }

    public Airport getAirport(){
        return airport;
    }
    public int getTailNumber(){
        return tailNumber;
    }
    public LocalTime getStartTime(){
        return landingInterval.getStartTime();
    }
    public LocalTime getEndTime(){
        return landingInterval.getEndTime();
    }
    public TimeInterval getLandingInterval(){
        return landingInterval;
    }

    @Override
    public int compareTo(Flight other) {
        return this.getStartTime().compareTo(other.getStartTime());
    }
}

