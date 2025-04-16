package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class sec06_05 {
    public static char solution(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        return (arr.length == set.size()) ? 'U' : 'D';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; ++i) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr));
    }
}
