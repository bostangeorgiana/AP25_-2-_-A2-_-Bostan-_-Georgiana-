import java.time.LocalTime;
/**
 * Clasa cupleaza doua valori temporale intr-o pereche
 */
public class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }

    public LocalTime getStartTime() {
        return getFirst();
    }

    public LocalTime getEndTime() {
        return getSecond();
    }
}
