package inflearn_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_07 {

//    public String solution(String str){
//        String answer="NO";
//        String tmp=new StringBuilder(str).reverse().toString();
//        if(str.equalsIgnoreCase(tmp)) answer="YES";
//        return answer;
//    }
    public static String solution(String str) {
        int lp = 0; int rp = str.length() -1;
        String lower = str.toLowerCase();
        char[] temp = lower.toCharArray();
        while (lp < rp){
            if(temp[lp] != temp[rp]){
                return "NO";
            }
            ++lp; --rp;
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
