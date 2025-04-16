package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//선택 정렬
public class sec06_01 {
    public static int[] solution(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i)
        {
            int min = arr[i];
            int minIdx = i;
            for(int j = i + 1; j <arr.length; ++j)
            {
                if(arr[j] < min)
                {
                    min = arr[j];
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minIdx] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for(int i : solution(arr)) System.out.print(i + " ");
    }
}
