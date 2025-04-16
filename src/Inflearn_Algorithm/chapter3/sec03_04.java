package Inflearn_Algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec03_04 {
    public static int solution(int N, int M, int[] arr)
    {
        int count = 0, sum = 0;
        int lptr = 0;

        for (int rptr = 0; rptr < N; ++rptr)
        {
            sum += arr[rptr];
            while (sum > M) sum -= arr[lptr++];
            if (sum == M) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, M, arr));
    }
}