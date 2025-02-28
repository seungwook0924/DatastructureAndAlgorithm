package Onlne_Judge.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Boj_13277
{
    public static void boj_13277(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger bigInteger1 = new BigInteger(st.nextToken());
        BigInteger bigInteger2 = new BigInteger(st.nextToken());

        System.out.println(bigInteger1.multiply(bigInteger2));
    }
}
