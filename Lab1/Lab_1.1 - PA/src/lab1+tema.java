import java.util.Random;
public class lab1{


    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        n = n * 3;
        n = n + 0b10101; //binare
        n = n + 0xFF; //hexadecimal
        n = n * 6;

        int s;
        while (n > 9) {
            s=0;
            while (n > 0) {
                s += n % 10;
                n /= 10;
            }
            n = s;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }


    public static void Homework(String[] args) {

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
    }


    


}
