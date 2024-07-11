package inflearn_algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_09 {
    public static String solution(String str) {
        String result = "";
        for (char c : str.toCharArray())
        {
            if(Character.isDigit(c))
            {
                if(!(c == '0') || !(result.length() == 0)) result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
