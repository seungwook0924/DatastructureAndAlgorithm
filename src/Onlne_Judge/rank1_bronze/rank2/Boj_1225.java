package Onlne_Judge.rank1_bronze.rank2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        long sumA = 0;
        long sumB = 0;

        for (int i = 0; i < A.length(); i++) sumA += (A.charAt(i) - '0');
        for (int i = 0; i < B.length(); i++) sumB += (B.charAt(i) - '0');

        System.out.println(sumA * sumB);
    }
}
