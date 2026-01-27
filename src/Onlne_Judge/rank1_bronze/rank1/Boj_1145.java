package Onlne_Judge.rank1_bronze.rank1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[5];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] < min) min = a[i];
        }

        int x = min;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) if (x % a[i] == 0) cnt++;

            if (cnt >= 3) {
                System.out.print(x);
                return;
            }
            x++;
        }
    }
}
