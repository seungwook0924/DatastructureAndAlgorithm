package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11660
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // n과 m을 받아옴
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 구간합 배열 생성
        int[][] sumArr = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; ++j)
            {
                if(i == 1) sumArr[i][j] = Integer.parseInt(st.nextToken()) + sumArr[i][j - 1];
                else if(j == 1) sumArr[i][j] = Integer.parseInt(st.nextToken()) + sumArr[i - 1][j];
                else sumArr[i][j] = Integer.parseInt(st.nextToken()) + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1]; // 핵심 로직 1
            }
        }

        // 구간 합을 통해서 값을 구함
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(sumArr[x2][y2] - sumArr[x1 - 1][y2] - sumArr[x2][y1 - 1] + sumArr[x1 - 1][y1 - 1]).append("\n"); // 핵심 로직 2
        }
        System.out.println(sb);
    }
}
