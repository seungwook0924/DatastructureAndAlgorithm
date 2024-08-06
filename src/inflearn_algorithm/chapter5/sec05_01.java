package inflearn_algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec05_01 {
    public static String solution(String str) {
        int left = 0;
        for(int i = 0; i < str.length(); ++i)
        {
            if(str.charAt(i) == '(') ++left;
            else
            {
                --left;
                if(left < 0) return "NO";
            }
        }
        return (left == 0) ? "YES" : "NO";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
