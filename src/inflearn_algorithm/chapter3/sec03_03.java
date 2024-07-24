package inflearn_algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec03_03 {
    public static int solution(int N, int K, int[] arr) {
        int tempSum = 0;
        for(int i = 0; i < K; ++i) tempSum += arr[i];
        int max = tempSum;

        for(int i = K; i < N; ++i)
        {
            tempSum += (arr[i] - arr[i - K]);
            if(tempSum > max) max = tempSum;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, K, arr));
    }
}
