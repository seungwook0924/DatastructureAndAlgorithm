package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2167 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + val;
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = arr[x][y] - arr[i - 1][y] - arr[x][j - 1] + arr[i - 1][j - 1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
