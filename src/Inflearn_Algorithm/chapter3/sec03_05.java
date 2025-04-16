package Inflearn_Algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec03_05 {
//    public static int solution(int N) {
//        int count = 0, sum = 0;
//        int lPtr = 0, halfPlusOne = (N / 2) + 1;
//        int[] arr = new int[halfPlusOne];
//
//        for(int i = 0; i < halfPlusOne; ++i) arr[i] = i + 1;
//
//        for(int rPtr = 0; rPtr < halfPlusOne; ++rPtr)
//        {
//            sum += arr[rPtr];
//            while (sum > N) sum -= arr[lPtr++];
//            if(sum == N) ++count;
//        }
//
//        return count;
//    }

    public static int solution(int N) {
        int count = 0, temp = 1;
        --N;
        while (N > 0)
        {
            N = N - (++temp);
            if(N % temp == 0) ++count;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
}
