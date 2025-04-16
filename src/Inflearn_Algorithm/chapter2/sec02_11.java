package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec02_11 {
    public static int solution(int n, int[][] arr)
    {
        int answer = 0, max = 0;

        // 각 학생 i에 대해 반복
        for(int i = 1; i <= n; ++i)
        {
            int count = 0;

            // 다른 모든 학생 j와 비교
            for(int j = 1; j <= n; ++j)
            {

                // 5년 동안 같은 반이었던 적이 있는지 확인
                for(int k = 1; k <= 5; ++k)
                {
                    if(arr[i][k] == arr[j][k])
                    { // 같은 반이었던 경우
                        count++;
                        break; // 더 이상 확인할 필요 없이 다음 학생으로 넘어감
                    }
                }
            }

            // 최대값 갱신
            if(count > max)
            {
                max = count;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][6]; // 1-based 인덱스 사용을 위해 배열 크기 설정

        for(int i = 1; i <= N; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 6; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}