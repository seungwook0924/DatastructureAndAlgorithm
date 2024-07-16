package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec02_08 {
    public static void solution(int N, String str) {
        StringTokenizer st = new StringTokenizer(str);
        int[] numArr = new int[N];
        for(int i = 0; i < N; ++i) numArr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; ++i)
        {
            int temp = numArr[i];
            int count = 1;
            for(int j = 0; j < N; ++j) if(temp < numArr[j]) ++count;
            System.out.print(count + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solution(N, br.readLine());
    }
}
