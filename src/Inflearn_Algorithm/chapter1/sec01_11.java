package Inflearn_Algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_11 {
    public static String solution(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); ++i) {
            if(str.charAt(i) == str.charAt(i - 1)) ++count;
            else
            {
                result.append(str.charAt(i - 1));
                if(count > 1) result.append(count);
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1)); //마지막 문자 처리
        if(count > 1) result.append(count);
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
