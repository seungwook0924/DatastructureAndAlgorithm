package Onlne_Judge.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23805
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        func(N);
    }

    static void func(int N)
    {
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N * 5; ++j)
            {
                if(j < 3 * N) System.out.print("@");
                else if(j >= N * 4) System.out.print("@");
                else System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < (N * 5) - 2 * N; ++i)
        {
            for (int j = 0; j < N * 5; ++j)
            {
                if((N <= j) && (j < 2 * N)) System.out.print(" ");
                else if((N * 3 <= j) && (j < 4 * N)) System.out.print(" ");
                else  System.out.print("@");
            }
            System.out.println();
        }

        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N * 5; ++j)
            {
                if(j < N) System.out.print("@");
                else if(j < N * 2) System.out.print(" ");
                else System.out.print("@");
            }
            System.out.println();
        }
    }
}
