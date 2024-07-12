package inflearn_algorithm.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec02_04 {
    public static void solution(int N) {
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

//    public static void solution2(Long N) {
//        Long p = 1L, n = 1L;
//        System.out.print(p + " " + n +" ");
//        for(int i = 2; i < N; ++i)
//        {
//            Long c = p + n;
//            System.out.print(c + " ");
//            p = n;
//            n = c;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(br.readLine()));
//        solution(Long.parseLong(br.readLine()));
    }
}
