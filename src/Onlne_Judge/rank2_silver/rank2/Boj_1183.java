package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1183 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] d = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            d[i] = B - A; // Di
        }

        Arrays.sort(d);

        if (N % 2 == 1) {
            System.out.println(1);
        } else {
            long left = d[N / 2 - 1];
            long right = d[N / 2];
            System.out.println(right - left + 1);
        }
    }
}
