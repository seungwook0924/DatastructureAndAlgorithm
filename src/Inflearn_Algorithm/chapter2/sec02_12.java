package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec02_12 {
    public static int solution(int N, int M, int[][] arr){
        int count = 0;

        // 순위를 저장할 배열
        int[][] rank = new int[M][N + 1];

        // 각 테스트에서 학생들의 순위를 미리 계산
        for (int k = 0; k < M; ++k)
        {
            for (int s = 0; s < N; ++s) rank[k][arr[k][s]] = s;
        }

        // 학생 쌍 (i, j) 에 대해 비교
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j)
            {
                int temp = 0;
                for (int k = 0; k < M; ++k) if (rank[k][i] < rank[k][j]) ++temp;
                if (temp == M) ++count;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];

        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, M, arr));
    }
}