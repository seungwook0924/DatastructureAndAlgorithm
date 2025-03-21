package Onlne_Judge.rank1_bronze.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2750
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n - i - 1; ++j)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    }
}
