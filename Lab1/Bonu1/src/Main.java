public class Main {
    public static void main(String[] args) {

            if (args.length < 2) {
                System.out.println(
                        "Trebuie sa introduci minim 2 numere");
                System.exit(-1);
            }

            long startTime=System.nanoTime();

            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);

            int[][] graf = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    graf[i][j] = -1;

            // k-clica:
            for(int i = 0; i < k; i++)
                for(int j = i+1; j < k; j++){
                    graf[i][j]=1;
                    graf[j][i]=1;
                }

            // set stabil de k noduri:
            for(int i = k; i < 2*k && k<n; i++)
                for(int j = k; j < 2*k && j<n; j++)
                    graf[i][j] = 0;


            // punem alte muchii random
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if(graf[i][j] == -1){
                        int p = (int) (Math.random());
                        if(p%2 == 0)
                        {
                            graf[i][j] = 1;
                            graf[j][i] = 1;
                        }
                        else
                        {
                            graf[i][j] = 0;
                            graf[j][i] = 0;
                        }
                    }

            if( n < 30_000) {
                //Afisarea matricei
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        if (graf[i][j] == 1)
                            System.out.print("1 ");
                        else
                            System.out.print("0 ");
                    System.out.println();
                }
            }
            else
            {
                long endTime=System.nanoTime();
                long duration=endTime-startTime;
                System.out.println("Running time (nanoseconds): "+duration);
                System.out.println("Running time (miliseconds): "+(duration/1000000));
            }



            // muchii, grade
            int m=0, mini=0, maxi=0;
            for (int i = 0; i < n; i++)
            {
                int grad=0;
                for (int j = 0; j < n; j++)
                    if (graf[i][j] == 1) {
                        m++;
                        grad++;
                    }
                if(i==0)
                {
                    mini=grad;
                    maxi=grad;
                }
                else if(mini>grad)
                    mini=grad;
                else if(maxi<grad)
                    maxi=grad;
            }

            int sumGrad=m;
            m=m/2;

            System.out.println("Numarul de muchii: " + m);
            System.out.println("\u03B4(m): " + mini);
            System.out.println("\u0394(m): " + maxi);
            if(m*2==sumGrad)
                System.out.println("Suma gradelor muchiilor este egala cu 2*m");
            else
                System.out.println("Suma gradelor muchiilor nu este egala cu 2*m");

            int ok_clica=0, ok_stabil=0;

            for(int i=0; i<n-k+1; i++) {
                int ok_c = 1, ok_s = 1;
                for (int j = i; j < k + i && (ok_s == 1 || ok_c == 1); j++)
                    for (int l = j + 1; l < k + i && (ok_s == 1 || ok_c == 1); l++) {
                        if (graf[j][l] != 1)
                            ok_c = 0;
                        if(graf[j][l] != 0)
                            ok_s=0;
                    }
                if(ok_c==1)
                    ok_clica=1;
                if(ok_s==1)
                    ok_stabil=1;
            }

            if(ok_clica==1)
                System.out.println("Avem k-clica");
            else
                System.out.println("Nu avem k-clica");
            if(ok_stabil==1)
                System.out.println("Avem k-stabil");
            else
                System.out.println("Nu avem k-stabil");
        }
    }
