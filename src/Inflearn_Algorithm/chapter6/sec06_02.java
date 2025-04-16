package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//버블 정렬
public class sec06_02 {
    public static int[] solution(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i)
        {
            for(int j = 0; j < arr.length - 1 - i; ++j)
            {
                if(arr[j] > arr[j + 1])
                {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        for (int i : solution(arr)) {
            System.out.print( i + " ");
        }
    }
}
