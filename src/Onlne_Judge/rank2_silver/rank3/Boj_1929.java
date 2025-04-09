package Onlne_Judge.rank2_silver.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1929
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < n + 1; ++i)
            if(isPrime[i])
                for(int j = i * i; j < n + 1; j += i)
                    isPrime[j] = false;

        for(int i = m; i <= n; ++i) if(isPrime[i]) System.out.println(i);
    }
}
