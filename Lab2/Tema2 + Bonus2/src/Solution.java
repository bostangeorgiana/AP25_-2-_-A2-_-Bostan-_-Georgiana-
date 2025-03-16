/**
 * Clasa Solution reprezinta solutia problemei de alocare a proiectelor studentilor.
 * Contine un array cu studentii si proiectele care le-au fost asignate.
 */
public class Solution {
    private Students[] students; ///< Lista de studenti
    private Project[] assignedProjects; ///< Lista de proiecte asignate studentilor

    /**
     * Constructor pentru clasa Solution.
     * @param students Lista de studenti implicati in alocare.
     */
    public Solution(Students[] students) {
        this.students = students;
        this.assignedProjects = new Project[students.length];
    }

    /**
     * Asigneaza un proiect unui student.
     * @param student Studentul caruia i se aloca proiectul.
     * @param project Proiectul asignat studentului.
     */
    public void assignProject(Students student, Project project) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                assignedProjects[i] = project;
                return;
            }
        }
    }

    /**
     * Afiseaza solutia finala a alocarii studentilor la proiecte.
     */
    public void displaySolution() {
        System.out.println("Final Allocation of Students to Projects:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName() + " -> " +
                    (assignedProjects[i] != null ? assignedProjects[i].getName() : "No project assigned"));
        }
    }

    /**
     * Returneaza proiectul asignat unui anumit student.
     * @param student Studentul pentru care se cauta proiectul asignat.
     * @return Proiectul asignat sau null daca nu are proiect.
     */
    public Project getAssignedProject(Students student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                return assignedProjects[i];
            }
        }
        return null;
    }
}
