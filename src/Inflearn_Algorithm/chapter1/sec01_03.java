package Inflearn_Algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec01_03 {
    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int max = 0;
        String text = "";
        while (st.hasMoreTokens()){
            String temp = st.nextToken();
            int length = temp.length();
            if(length > max) {
                max = length;
                text = temp;
            }
        }
        return text;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        System.out.println(solution(text));
    }
}
