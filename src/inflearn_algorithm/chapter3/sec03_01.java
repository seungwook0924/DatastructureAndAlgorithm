package inflearn_algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sec03_01 {
    public static int[] solution(int[] arr1, int[] arr2) {
        int[] mergeArr = new int[arr1.length + arr2.length];
        int ptr1 = 0, ptr2 = 0, i = 0;

        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] <= arr2[ptr2]) mergeArr[i++] = arr1[ptr1++];
            else mergeArr[i++] = arr2[ptr2++];
        }

        while (ptr1 < arr1.length) mergeArr[i++] = arr1[ptr1++];
        while (ptr2 < arr2.length) mergeArr[i++] = arr2[ptr2++];

        return mergeArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) arr2[i] = Integer.parseInt(st.nextToken());

        for (int i : solution(arr1, arr2)) System.out.print(i + " ");
    }
}
