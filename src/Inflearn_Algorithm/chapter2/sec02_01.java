package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec02_01 {
    public static String solution(int N, String str) {
        String[] numArr = str.split(" ");
        StringBuilder sb = new StringBuilder();

        sb.append(numArr[0]).append(" ");
        for (int i = 1; i < N; i++)
        {
            if (Integer.parseInt(numArr[i]) > Integer.parseInt(numArr[i - 1]))
            {
                sb.append(numArr[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(solution(N, input));
    }
}