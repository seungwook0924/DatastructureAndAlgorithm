package Inflearn_Algorithm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class sec04_02 {
    public static String solution(String str1, String str2)
    {
        if(str1.length() != str2.length()) return "NO";
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        
        for(int i = 0; i < str1.length(); ++i)
        {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        for(char c : map1.keySet()) if(!(map2.containsKey(c) && (map2.get(c).equals(map1.get(c))))) return "NO";

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        System.out.println(solution(input1, input2));
    }
}
