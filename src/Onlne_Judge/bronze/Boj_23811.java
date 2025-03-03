package Onlne_Judge.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23811
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        func(N);
    }

    static void func(int N)
    {
        for(int i = 0; i < N * 5; ++i)
        {
            for (int j = 0; j < N * 5; ++j)
            {
                if(i < N) System.out.print("@");
                else if((i >= N * 2) && (i < N * 3)) System.out.print("@");
                else if(i >= N * 4) System.out.print("@");
                else if(j < N)  System.out.print("@");
            }
            System.out.println();
        }
    }
}
