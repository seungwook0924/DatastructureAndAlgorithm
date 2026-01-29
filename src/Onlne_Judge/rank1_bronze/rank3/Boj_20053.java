package Onlne_Judge.rank1_bronze.rank3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20053 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (x < min) min = x;
                if (x > max) max = x;
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb.toString());
    }
}
