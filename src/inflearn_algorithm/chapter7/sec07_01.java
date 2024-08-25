package inflearn_algorithm.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec07_01 {
//    public static void solution(int start, int N)
//    {
//        System.out.print(start + " ");
//        if(start >= N) return;
//        solution(start + 1, N);
//    }

    public static void solution(int N)
    {
        if(N <= 0) return;
        solution(N - 1);
        System.out.print(N + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solution(N);
    }
}
