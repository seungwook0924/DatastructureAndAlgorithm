package Inflearn_Algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec02_07 {
    public static int solution(int N, String str) {
        int count = 0; int sum = 0;
        String[] input = str.split(" ");
        for (String s : input) {
            if(s.equals("1")) count += ++sum;
            else sum = 0;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N, br.readLine()));
    }
}
