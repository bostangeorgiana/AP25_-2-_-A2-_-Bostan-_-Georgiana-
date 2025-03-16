/**
 * Clasa Teachers reprezinta un profesor care poate propune proiecte.
 * Profesorul mosteneste clasa Persons si poate avea o lista de proiecte.
 */
class Teachers extends Persons {
    private Project[] projects;
    private int projectCount;

    /**
     * Constructor pentru clasa Teachers.
     * @param name Numele profesorului.
     * @param birthDate Data de nastere a profesorului.
     */
    Teachers(String name, String birthDate) {
        super(name, birthDate);
        this.projects = new Project[11];
        this.projectCount = 0;
    }

    /**
     * Adauga un proiect la lista profesorului.
     * @param project Proiectul care trebuie adaugat.
     */
    public void addProject(Project project) {
        if (projectCount < 11) {
            projects[projectCount++] = project;
            project.setTeacherName(this.name);
        } else {
            System.out.println("Nu se mai pot adauga mai multe proiecte.");
        }
    }

    /**
     * Returneaza lista de proiecte ale profesorului.
     * @return Un array de proiecte.
     */
    public Project[] getProjects() {
        return projects;
    }
}
