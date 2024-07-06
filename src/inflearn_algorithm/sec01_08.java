package inflearn_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_08 {

//    public String solution(String s){
//        String answer="NO";
//        s=s.toUpperCase().replaceAll("[^A-Z]", "");
//        String tmp=new StringBuilder(s).reverse().toString();
//        if(s.equals(tmp)) answer="YES";
//        return answer;
//    }
    public static String solution(String str) {
        int lp = 0; int rp = str.length() - 1;
        String lower = str.toLowerCase();
        while (lp < rp) {
            // 왼쪽 포인터가 가리키는 문자가 알파벳이나 숫자가 아닐 때 포인터 이동
            while (lp < rp && !Character.isLetterOrDigit(lower.charAt(lp))) lp++;
            // 오른쪽 포인터가 가리키는 문자가 알파벳이나 숫자가 아닐 때 포인터 이동
            while (lp < rp && !Character.isLetterOrDigit(lower.charAt(rp))) rp--;

            // 양 끝 문자가 다르면 회문이 아님
            if (lower.charAt(lp) != lower.charAt(rp)) return "NO";

            // 양 끝 문자가 같으면 포인터 이동
            lp++;
            rp--;
        }
        return "YES";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
