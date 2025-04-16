package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sec06_08 {
//    public static int solution(int[] arr, int M) {
//        Arrays.sort(arr);
//        return Arrays.binarySearch(arr, M) + 1;
//    }

    public static int solution(int[] arr, int M) {
        Arrays.sort(arr);
        int lPtr = 0; int rPtr = arr.length - 1;
        while(lPtr <= rPtr)
        {
            int mid = (lPtr + rPtr) / 2;
            if(arr[mid] == M) return mid + 1;
            else
            {
                if(arr[mid] > M) rPtr = mid - 1;
                else lPtr = mid + 1;
            }
        }
        return -1;
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
