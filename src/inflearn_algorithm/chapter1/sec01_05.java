package inflearn_algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec01_05 {
    public static String solution(String str) {
        char[] temp = str.toCharArray();
        int lp = 0; int rp = str.length() - 1;
        while (lp < rp){
            if(!Character.isAlphabetic(temp[lp])) ++lp;
            else if(!Character.isAlphabetic(temp[rp])) --rp;
            else {
                char tmp = temp[lp];
                temp[lp] = temp[rp];
                temp[rp] = tmp;
                ++lp; --rp;
            }
        }
        return String.valueOf(temp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
