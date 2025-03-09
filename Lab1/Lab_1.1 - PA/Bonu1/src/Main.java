public class Main {

    static int[] candidates, viz, solution;
    static int candidatesSize = 0, solutionSize = 0;

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println(
                    "Trebuie sa introduci minim 2 numere");
            System.exit(-1);
        }

        long startTime = System.nanoTime();

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[][] graf = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graf[i][j] = -1;

        // k-clica:
        for (int i = 0; i < k; i++)
            for (int j = i + 1; j < k; j++) {
                graf[i][j] = 1;
                graf[j][i] = 1;
            }

        // set stabil de k noduri:
        for (int i = k; i < 2 * k && k < n; i++)
            for (int j = k; j < 2 * k && j < n; j++)
                graf[i][j] = 0;

        // punem alte muchii random
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (graf[i][j] == -1) {
                    int p = (int) (Math.random());
                    if (p % 2 == 0) {
                        graf[i][j] = 1;
                        graf[j][i] = 1;
                    } else {
                        graf[i][j] = 0;
                        graf[j][i] = 0;
                    }
                }

        if (n < 30_000) {
            // Afisarea matricei
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    if (graf[i][j] == 1)
                        System.out.print("1 ");
                    else
                        System.out.print("0 ");
                System.out.println();
            }
        } else {
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Running time (nanoseconds): " + duration);
            System.out.println("Running time (miliseconds): " + (duration / 1000000));
        }

        // muchii, grade
        int numberEdges = 0, mini = 0, maxi = 0;
        for (int i = 0; i < n; i++) {
            int grad = 0;
            for (int j = 0; j < n; j++)
                if (graf[i][j] == 1) {
                    numberEdges++;
                    grad++;
                }
            if (i == 0) {
                mini = grad;
                maxi = grad;
            } else if (mini > grad)
                mini = grad;
            else if (maxi < grad)
                maxi = grad;
        }

        int sumGrad = numberEdges;
        numberEdges = numberEdges / 2;

        System.out.println("Numarul de muchii: " + numberEdges);
        System.out.println("\u03B4(m): " + mini);
        System.out.println("\u0394(m): " + maxi);
        if (numberEdges * 2 == sumGrad)
            System.out.println("Suma gradelor muchiilor este egala cu 2*numberEdges");
        else
            System.out.println("Suma gradelor muchiilor nu este egala cu 2*numberEdges");


        //BONUS

        candidates = new int[n];
        viz = new int[n];
        solution = new int[k];


        for (int i = 0; i < n; i++) {
            int grad = 0;
            for (int j = 0; j < n; j++)
                if (graf[i][j] == 1)
                    grad++;

            if (grad >= k - 1)
                candidates[candidatesSize++] = i;
        }

        for (int i = 0; i < candidatesSize; i++) {
            for (int j = 0; j < n; j++)
                viz[j] = 0;
            solutionSize = 0;
            bkt(candidates[i], k, graf);
        }
    }

    public static void bkt(int candidate, int k, int graf[][]) {
        viz[candidate] = 1;
        solution[solutionSize++] = candidates[candidate];

        if (solutionSize == k) {
            System.out.println("Exista clica");
            for (int i = 0; i < k; i++)
                System.out.print(solution[i] + " ");
            System.out.println();
            return;
        }

        for (int i = candidate + 1; i < candidatesSize; i++) {
            if (viz[i] == 0) {
                boolean ok = true;
                for (int j = 0; j < solutionSize; j++)
                    if (graf[solution[j]][candidates[i]] == 0 || graf[candidates[i]][rsolution[j]] == 0) {
                        ok = false;
                        break;
                    }
                if (ok) {
                    bkt(i, k, graf);
                    viz[i] = 0;
                    solutionSize--;
                }
            }
        }
    }
}
