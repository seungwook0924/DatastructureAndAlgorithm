package Inflearn_Algorithm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class sec04_03 {
    public static int[] solution(int[] arr, int K) {
        int[] result = new int[arr.length - K + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < K; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        result[0] = map.size();

        int lPtr = 0;
        for (int rPtr = K; rPtr < arr.length; ++rPtr)
        {
            map.put(arr[rPtr], map.getOrDefault(arr[rPtr], 0) + 1);
            map.put(arr[lPtr], map.get(arr[lPtr]) - 1);
            if (map.get(arr[lPtr]) == 0) map.remove(arr[lPtr]);
            ++lPtr;
            result[rPtr - K + 1] = map.size();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(arr, K)) System.out.print(i + " ");
    }
}