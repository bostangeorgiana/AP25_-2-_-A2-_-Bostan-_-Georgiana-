/**
 * Clasa Students reprezinta un student care poate alege proiecte.
 * Studentul mosteneste clasa Persons si are un ID unic si o lista de preferinte pentru proiecte.
 */
class Students extends Persons {
    private Project[] preferences;
    private int id;

    /**
     * Constructor pentru clasa Students.
     * @param name Numele studentului.
     * @param birthDate Data de nastere a studentului.
     * @param id ID-ul unic al studentului.
     * @param preferences Lista de proiecte preferate de student.
     */
    public Students(String name, String birthDate, int id, Project[] preferences) {
        super(name, birthDate);
        this.id = id;
        this.preferences = preferences;
    }

    /**
     * Returneaza ID-ul studentului.
     * @return ID-ul studentului.
     */
    public int getId() {
        return id;
    }

    /**
     * Returneaza lista de proiecte preferate de student.
     * @return Un array de obiecte de tip Project.
     */
    public Project[] getPreferences() {
        return preferences;
    }
}
