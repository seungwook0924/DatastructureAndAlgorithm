package inflearn_algorithm.Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sec06_06 {
    public static ArrayList<Integer> solution(int[] arr)
    {
        int[] copy = arr.clone();
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(copy);
        for (int i = 0; i < arr.length; ++i) if(arr[i] != copy[i]) answer.add(i + 1);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(arr)) System.out.print(i + " ");
    }
}
