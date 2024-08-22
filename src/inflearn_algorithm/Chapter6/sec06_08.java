package inflearn_algorithm.Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sec06_08 {
    public static int solution(int[] arr, int M) {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, M) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, M));
    }
}
