package inflearn_algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec03_06 {
    public static int solution(int[] arr, int N, int K) {
        int maxLength = 0;
        int lPtr = 0, count = 0;
        for(int rPtr = 0; rPtr < N; ++rPtr)
        {
            if(arr[rPtr] == 0) ++count;
            while(count > K) if(arr[lPtr++] == 0) --count;
            if(rPtr - lPtr + 1 > maxLength) maxLength = rPtr - lPtr + 1;
        }


        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, N, K));
    }
}
