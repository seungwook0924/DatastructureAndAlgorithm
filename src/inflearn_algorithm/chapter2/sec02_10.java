package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec02_10 {
    public static int solution(int N, int[][] arr) {
        int count = 0;
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                if((arr[i - 1][j] < arr[i][j]) && (arr[i][j - 1] < arr[i][j]) &&
                    (arr[i][j + 1] < arr[i][j]) && (arr[i + 1][j] < arr[i][j]))
                {
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][N + 2];
        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}
