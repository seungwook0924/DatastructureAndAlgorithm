package Onlne_Judge.rank1_bronze.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_23802
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
            if(i >= N)
            {
                for (int j = 0; j < N; ++j) System.out.print("@");
                System.out.println();
            }
            else
            {
                for(int j = 0; j < N * 5; ++j) System.out.print("@");
                System.out.println();
            }
        }
    }
}
