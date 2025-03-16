/**
 * Enumeratie care defineste tipul unui proiect.
 */
enum ProjectType {
    THEORETICAL,  ///< Proiect teoretic
    PRACTICAL     ///< Proiect practic
}

/**
 * Clasa Project reprezinta un proiect care poate fi alocat unui student.
 * Fiecare proiect are un nume, un tip (teoretic sau practic) si un profesor care l-a propus.
 */
public class Project {
    private String name;
    private ProjectType type;
    private String teacherName;

    /**
     * Constructor pentru clasa Project.
     * @param name Numele proiectului.
     * @param type Tipul proiectului (THEORETICAL sau PRACTICAL).
     */
    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Seteaza numele profesorului care a propus proiectul.
     * @param teacherName Numele profesorului.
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * Returneaza numele profesorului care a propus proiectul.
     * @return Numele profesorului.
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * Returneaza numele proiectului.
     * @return Numele proiectului.
     */
    public String getName() {
        return name;
    }

    /**
     * Returneaza tipul proiectului (teoretic sau practic).
     * @return Tipul proiectului.
     */
    public ProjectType getType() {
        return type;
    }

    /**
     * Seteaza tipul proiectului.
     * @param type Noul tip al proiectului.
     */
    public void setType(ProjectType type) {
        this.type = type;
    }

    /**
     * Seteaza numele proiectului.
     * @param name Noul nume al proiectului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Verifica daca doua proiecte sunt egale (au acelasi nume).
     * @param obj Obiectul de comparat.
     * @return true daca proiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project project = (Project) obj;
        return name.equals(project.name);
    }

    /**
     * Returneaza codul hash al proiectului, calculat pe baza numelui.
     * @return Codul hash al proiectului.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Returneaza o reprezentare textuala a proiectului.
     * @return Un string care contine numele si tipul proiectului.
     */
    @Override
    public String toString() {
        return "Project [name=" + name + ", type=" + type + "]";
    }
}
