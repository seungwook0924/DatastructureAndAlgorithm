package inflearn_algorithm.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec07_03 {
    public static int solution(int N) {
        if(N <= 1) return N;
        return N * solution(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(br.readLine())));
    }
}
