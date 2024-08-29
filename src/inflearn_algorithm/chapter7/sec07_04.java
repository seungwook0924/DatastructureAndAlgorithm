package inflearn_algorithm.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec07_04 {
    static String[] memo;
    public static void solution(int N)
    {
        Long[] arr = new Long[N];
        arr[0] = 1L;
        arr[1] = 1L;
        System.out.print(arr[0] + " ");
        System.out.print(arr[1] + " ");
        for(int i = 2; i < N; ++i)
        {
            arr[i] = arr[i - 2] + arr[i - 1];
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(br.readLine()));
    }
}
