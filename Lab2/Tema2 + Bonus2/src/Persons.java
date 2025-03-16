/**
 * Clasa abstracta pentru o persoana.
 * Reprezinta o persoana generica, avand un nume si o data de nastere.
 */
abstract class Persons {
    protected String name;
    protected String birthDate;

    /**
     * Constructor pentru o persoana.
     * @param name Numele persoanei.
     * @param birthDate Data nasterii persoanei.
     */
    public Persons(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * Returneaza numele persoanei.
     * @return Numele persoanei.
     */
    public String getName() {
        return name;
    }

    /**
     * Returneaza data de nastere a persoanei.
     * @return Data nasterii.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Seteaza numele persoanei.
     * @param name Noul nume al persoanei.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Seteaza data de nastere a persoanei.
     * @param birthDate Noua data de nastere.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Compara doua obiecte de tip Persons pentru egalitate.
     * @param obj Obiectul de comparat.
     * @return true daca cele doua obiecte sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persons person = (Persons) obj;
        return name.equals(person.name) && birthDate.equals(person.birthDate);
    }

    /**
     * Returneaza codul hash al obiectului.
     * @return Codul hash calculat pe baza numelui si datei de nastere.
     */
    @Override
    public int hashCode() {
        return (name + birthDate).hashCode();
    }
}
