package Onlne_Judge.rank2_silver.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n과 m을 받아옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 구간합 배열 생성
        int[] sumArr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; ++i) sumArr[i] += Integer.parseInt(st.nextToken()) + sumArr[i - 1];

        // 구간 합을 통해서 값을 구함
        for (int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sumArr[end] - sumArr[start - 1]).append("\n");
        }
        System.out.println(sb);
    }
}