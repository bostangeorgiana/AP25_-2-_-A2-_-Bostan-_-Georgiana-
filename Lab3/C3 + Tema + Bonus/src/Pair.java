import java.util.Objects;

/**
 * Clasa cupleaza doua valori impreuna.
 * Este "universala", deoarece nu implementeaza un tip specific; pot fi formate perechi de diferite tipuri.
 * @param <T>
 * @param <U>
 */

public class Pair<T, U>
{
    private T first;
    private U second;

    public Pair(T first, U second)
    {
        this.first=first;
        this.second=second;
    }

    public T getFirst()
    {
        return first;
    }

    public void setFirst(T first)
    {
        this.first = first;
    }

    public U getSecond()
    {
        return second;
    }

    public void setSecond(U second)
    {
        this.second = second;
    }

//    @Override
//    public String toString() {
//        return "Pair{" +
//                "first=" + first +
//                ", second=" + second +
//                '}';
//    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }
}
