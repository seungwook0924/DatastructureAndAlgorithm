package inflearn_algorithm.Chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec06_03 {
    public static int[] solution(int[] arr) {
        for(int i = 1; i < arr.length; ++i)
        {
            int targetValue = arr[i];
            int j = i - 1;
            for(; j >= 0; --j)
            {
                if(arr[j] > targetValue) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = targetValue;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(arr)) System.out.print(i + " ");
    }
}
