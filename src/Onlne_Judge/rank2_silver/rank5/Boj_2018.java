package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2018
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            int sum = 0;
            for (int j = i; j <= n; j++)
            {
                sum += j;
                if(sum > n) break;
                if(sum == n)
                {
                    ++count;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
