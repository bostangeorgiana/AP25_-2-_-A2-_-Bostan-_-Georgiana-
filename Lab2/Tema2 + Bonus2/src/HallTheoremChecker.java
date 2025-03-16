public class HallTheoremChecker {
    private Students[] students;
    private Project[] projects;

    public HallTheoremChecker(Students[] students, Project[] projects) {
        this.students = students;
        this.projects = projects;
    }

    public boolean isAllocationPossible() {
        int n = students.length;
        int m = projects.length;
        boolean[] projectUsed = new boolean[m];

        // Generam toate subseturile
        int totalSubsets = (int) Math.pow(2, n);
        for (int subset = 1; subset < totalSubsets; subset++) {
            boolean[] includedStudents = new boolean[n];
            int studentCount = 0;
            int availableProjectCount = 0;
            boolean[] tempUsed = new boolean[m];

            // Construim subsetul de studenți
            int index = 0;
            int tempSubset = subset;
            while (tempSubset > 0) {
                if (tempSubset % 2 == 1) { // Verificam daca studentul index trebuie inclus
                    includedStudents[index] = true;
                    studentCount++;
                }
                tempSubset /= 2;
                index++;
            }

            // Verificam cate proiecte sunt disponibile pentru acest subset
            for (int i = 0; i < n; i++) {
                if (includedStudents[i]) {
                    for (Project p : students[i].getPreferences()) {
                        int projectIndex = findProjectIndex(p);
                        if (projectIndex != -1 && !tempUsed[projectIndex]) {
                            tempUsed[projectIndex] = true;
                            availableProjectCount++;
                        }
                    }
                }
            }

            // Condiția Teoremei lui Hall
            if (availableProjectCount < studentCount) {
                return false;
            }
        }
        return true;
    }

    private int findProjectIndex(Project project) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i].equals(project)) {
                return i;
            }
        }
        return -1;
    }
}
