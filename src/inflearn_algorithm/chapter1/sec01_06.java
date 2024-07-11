package inflearn_algorithm.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class sec01_06 {
//    public static String solution(String str) {
//        StringBuilder sb = new StringBuilder();
//        HashMap<Character, Boolean> map = new HashMap<>();
//        for (char c : str.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, true);
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    public static String solution(String str){
        String result = "";
        for (int i = 0; i < str.length(); ++i) {
            if(str.indexOf(str.charAt(i)) == i) result += str.charAt(i);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
