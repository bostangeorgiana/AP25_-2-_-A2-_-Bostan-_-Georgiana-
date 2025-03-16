/**
 * Clasa Main este punctul de intrare al aplicatiei.
 * Creeaza profesori, studenti si proiecte, si testeaza alocarea acestora.
 */
public class Main {
    /**
     * Metoda principala a aplicatiei. Creeaza obiectele necesare si aplica algoritmul de alocare a proiectelor.
     * @param args Argumentele din linia de comanda (neutilizate).
     */
    public static void main(String[] args) {
        // Creare profesori
        Teachers teacher1 = new Teachers("Prof. Popescu", "1975-03-10");
        Teachers teacher2 = new Teachers("Prof. Ionescu", "1980-07-15");

        // Creare proiecte
        Project project1 = new Project("P1", ProjectType.THEORETICAL);
        Project project2 = new Project("P2", ProjectType.PRACTICAL);
        Project project3 = new Project("P3", ProjectType.THEORETICAL);
        Project project4 = new Project("P4", ProjectType.PRACTICAL);

        // Asociere proiecte cu profesori
        teacher1.addProject(project1);
        teacher1.addProject(project2);
        teacher2.addProject(project3);
        teacher2.addProject(project4);

        // Creare studenti si preferinte
        Students student1 = new Students("S1", "2002-05-10", 101, new Project[]{project1, project2});
        Students student2 = new Students("S2", "2001-08-21", 102, new Project[]{project1, project3});
        Students student3 = new Students("S3", "2003-02-12", 103, new Project[]{project3, project4});
        Students student4 = new Students("S4", "2002-11-30", 104, new Project[]{project1, project4});

        // Creare liste studenti, profesori si proiecte
        Students[] students = {student1, student2, student3, student4};
        Teachers[] teachers = {teacher1, teacher2};
        Project[] projects = {project1, project2, project3, project4};

        // Creare problema si alocare proiecte
        Problem problem = new Problem(students, teachers, projects);
        problem.allocateProjects(); // Aplicare algoritm greedy si afisare solutie

        // Afisare lista completa de persoane implicate
        System.out.println("\n🔹 Toate persoanele implicate:");
        for (Persons p : problem.getAllPersons()) {
            System.out.println(p.getName() + " - " + p.getBirthDate());
        }
    }
}
