package inflearn_algorithm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class sec04_04 {
    public static int solution(String S, String T) {
        int count = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : T.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1); //T를 관리하는 맵 초기화
        for (int i = 0; i < T.length() - 1; ++i) sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1); //S를 관리하는 맵 초기화

        int lPtr = 0;
        for (int rPtr = T.length() - 1; rPtr < S.length(); ++rPtr)
        {
            sMap.put(S.charAt(rPtr), sMap.getOrDefault(S.charAt(rPtr), 0) + 1);
            if (sMap.equals(tMap)) ++count;
            sMap.put(S.charAt(lPtr), sMap.get(S.charAt(lPtr)) - 1);
            if (sMap.get(S.charAt(lPtr)) == 0) sMap.remove(S.charAt(lPtr));
            ++lPtr;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(solution(S, T));
    }
}