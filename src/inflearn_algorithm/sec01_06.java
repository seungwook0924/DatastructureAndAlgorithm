package inflearn_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class sec01_06 {
    public static String solution(String str) {
        StringBuilder sb = new StringBuilder(new String(""));
        HashMap<Character, Integer> map = new HashMap<>(0);
        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                int num = map.get(c);
                map.put(c, ++num);
            }
            else {
                map.put(c, 1);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }
}
