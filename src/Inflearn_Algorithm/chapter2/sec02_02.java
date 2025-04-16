package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec02_02 {
    public static int solution(int N, String str) {
        String[] numArr = str.split(" ");
        int count = 1;
        int previousNum = Integer.parseInt(numArr[0]);

        for (int i = 1; i < N; ++i)
        {
            int currentNum = Integer.parseInt(numArr[i]);
            if (currentNum > previousNum) {
                ++count;
                previousNum = currentNum;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(solution(N, input));
    }
}