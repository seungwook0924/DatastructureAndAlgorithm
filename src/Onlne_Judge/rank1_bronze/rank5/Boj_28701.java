package Onlne_Judge.rank1_bronze.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_28701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 1; i <= n; ++i) sum += i;
        sb.append(sum).append("\n")
                .append((int)Math.pow(sum, 2)).append("\n");

        sum = 0;
        for (int i = 1; i <= n; ++i) sum += (int)Math.pow(i, 3);
        sb.append(sum);

        System.out.println(sb);
    }
}
