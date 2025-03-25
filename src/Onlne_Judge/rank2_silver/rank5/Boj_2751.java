package Onlne_Judge.rank2_silver.rank5;

import java.io.*;
import java.util.Arrays;

public class Boj_2751
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; ++i) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; ++i) System.out.println(arr[i]);
    }
}
