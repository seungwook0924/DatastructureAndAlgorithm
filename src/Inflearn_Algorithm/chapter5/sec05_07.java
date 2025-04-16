package Inflearn_Algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sec05_07 {
    public static String solution(String sequence, String str) {
        Queue<Character> que = new LinkedList<>();
        for (char c : sequence.toCharArray()) que.add(c);
        for (char c : str.toCharArray()) if(!que.isEmpty() && que.peek() == c) que.poll();
        if(!que.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine(), br.readLine()));
    }
}
