package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sec02_05 {
    public static int solution(int N) {
        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);

        int count = 0;
        for(int i = 2; i <= Math.sqrt(N); ++i){
            if(arr[i]){
               for(int j = i * i; j <= N; j += i) arr[j] = false;
            }
        }

        for(int i = 2; i <= N; ++i) if(arr[i]) ++count;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }
}
