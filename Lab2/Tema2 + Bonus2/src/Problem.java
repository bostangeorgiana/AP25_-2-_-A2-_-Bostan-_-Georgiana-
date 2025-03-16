/**
 * Clasa Problem reprezinta problema alocarii studentilor la proiecte.
 * Aceasta contine listele de studenti, profesori si proiecte, precum si o solutie pentru alocare.
 */
public class Problem {
    private Students[] students; ///< Lista de studenti
    private Teachers[] teachers; ///< Lista de profesori
    private Project[] projects;  ///< Lista de proiecte
    private Solution solution;   ///< Obiect pentru stocarea solutiei

    /**
     * Constructor pentru clasa Problem.
     * @param students Lista de studenti implicati in alocare.
     * @param teachers Lista de profesori care propun proiecte.
     * @param projects Lista de proiecte disponibile.
     */
    public Problem(Students[] students, Teachers[] teachers, Project[] projects) {
        this.students = students;
        this.teachers = teachers;
        this.projects = projects;
        this.solution = new Solution(students);
    }

    /**
     * Returneaza un array cu toate persoanele implicate (atat studenti, cat si profesori).
     * @return Un array de obiecte de tip Persons.
     */
    public Persons[] getAllPersons() {
        Persons[] persons = new Persons[students.length + teachers.length];
        for (int i = 0; i < students.length; i++) {
            persons[i] = students[i];
        }
        for (int j = 0; j < teachers.length; j++) {
            persons[students.length + j] = teachers[j];
        }
        return persons;
    }

    /**
     * Metoda care aloca proiecte studentilor folosind un algoritm greedy.
     * Fiecare student primeste primul proiect preferat disponibil.
     */
    public void allocateProjects() {
        boolean[] projectTaken = new boolean[projects.length];

        for (int i = 0; i < students.length; i++) {
            for (Project preferredProject : students[i].getPreferences()) {
                int projectIndex = findProjectIndex(preferredProject);
                if (projectIndex != -1 && !projectTaken[projectIndex]) {
                    projectTaken[projectIndex] = true;
                    solution.assignProject(students[i], preferredProject);
                    break;
                }
            }
        }

        // Afisarea solutiei finale
        solution.displaySolution();
    }

    /**
     * Cauta indexul unui proiect in lista de proiecte disponibile.
     * @param preferredProject Proiectul cautat.
     * @return Indexul proiectului in lista, sau -1 daca nu este gasit.
     */
    private int findProjectIndex(Project preferredProject) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i].getName().equals(preferredProject.getName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returneaza lista de proiecte disponibile.
     * @return Un array de obiecte de tip Project.
     */
    public Project[] getProjects() {
        return projects;
    }
}
