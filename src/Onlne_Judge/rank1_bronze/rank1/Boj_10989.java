package Onlne_Judge.rank1_bronze.rank1;

import java.io.*;
import java.util.Arrays;

public class Boj_10989
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; ++i) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; ++i) bw.write(arr[i] + "\n");
        bw.flush();
    }
}
