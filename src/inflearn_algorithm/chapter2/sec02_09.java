package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class sec02_09 {
//    public static int solution(int N, int[][] numArr) {
//        int rightUp = 0;
//        for(int i = 0; i < N; ++i)
//        {
//            int colSum = 0;
//            for(int j = 0; j < N; ++j)
//            {
//                colSum += numArr[j][i];
//                if(i + j == N - 1) rightUp += numArr[i][j];
//            }
//            numArr[N][i] = colSum;
//        }
//        int max = 0;
//        for(int i = 0; i < N; ++i) if(max < numArr[i][N]) max = numArr[i][N];
//        for(int i = 0; i < N; ++i) if(max < numArr[N][i]) max = numArr[N][i];
//        if(max < rightUp) max = rightUp;
//        return max;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[][] arr = new int[N + 1][N + 1];
//        int rightDown = 0;
//        for(int i = 0; i < N; ++i) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int rowSum = 0;
//            for(int j = 0; j < N; ++j)
//            {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//                rowSum += arr[i][j];
//                if(i == j) rightDown += arr[i][j];
//            }
//            arr[i][N] = rowSum;
//        }
//        arr[N][N] = rightDown;
//        System.out.println(solution(N, arr));
//    }
//}

//개선된 코드
public class sec02_09 {
    public static int solution(int N, int[][] numArr) {
        int max = 0;

        // 행의 합과 열의 합을 구하고, 대각선 합도 동시에 구한다.
        int rightUp = 0;
        int rightDown = 0;

        for (int i = 0; i < N; ++i)
        {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < N; ++j)
            {
                rowSum += numArr[i][j];
                colSum += numArr[j][i];
                if (i == j) rightDown += numArr[i][j];
                if (i + j == N - 1) rightUp += numArr[i][j];
            }
            max = Math.max(max, rowSum);
            max = Math.max(max, colSum);
        }

        max = Math.max(max, rightDown);
        max = Math.max(max, rightUp);

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}