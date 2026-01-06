package Onlne_Judge.rank1_bronze.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1009 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = 1;
            for (int j = 0; j < b; ++j) {
                res *= a;
                res %= 10;
            }
            if (res == 0) sb.append(10);
            else sb.append(res);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
