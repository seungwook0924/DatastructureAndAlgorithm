package Onlne_Judge.rank1_bronze.rank2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1453 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        boolean[] used = new boolean[101]; // 좌석 1~100
        int rejected = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int seat = Integer.parseInt(st.nextToken());
            if (used[seat]) rejected++;
            else used[seat] = true;
        }

        System.out.println(rejected);
    }
}
