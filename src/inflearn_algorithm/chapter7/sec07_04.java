package inflearn_algorithm.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec07_04 {
    static int[] memo;
    public static int solution(int N)
    {
        if(memo[N] > 0) return memo[N];
        if(N == 1) return memo[N] = 1;
        else if(N == 2) return memo[N] = 1;
        else return memo[N] = solution(N - 2) + solution(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        solution(N);
        for (int i = 1; i < memo.length; ++i) System.out.print(memo[i] + " ");
    }
}
