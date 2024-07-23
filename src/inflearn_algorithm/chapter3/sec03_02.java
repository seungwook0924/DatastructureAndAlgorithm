package inflearn_algorithm.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sec03_02 {
    public static ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> integers = new ArrayList<>();
        Arrays.sort(arr1); Arrays.sort(arr2);
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < arr1.length && ptr2 < arr2.length)
        {
            if (arr1[ptr1] == arr2[ptr2])
            {
                integers.add(arr1[ptr1]);
                ++ptr1;
                ++ptr2;
            }
            else if (arr1[ptr1] < arr2[ptr2]) ++ptr1;
            else if (arr1[ptr1] > arr2[ptr2]) ++ptr2;
        }

        return integers;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for(int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        for (Integer i : solution(arr, arr2)) System.out.print(i + " ");
    }
}
