package Inflearn_Algorithm.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sec06_09 {
    public static int count(int[] arr, int mid)
    {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; ++i)
        {
            if(sum + arr[i] > mid)
            {
                ++count;
                sum = arr[i];
            }
            else sum += arr[i];
        }
        return count;
    }

    public static int solution(int[] arr, int N, int M)
    {
        int lPtr = Arrays.stream(arr).max().getAsInt();  // 배열의 최대값
        int rPtr = Arrays.stream(arr).sum();  // 배열의 총합
        int answer = 0;

        while(lPtr <= rPtr)
        {
            int mid = (lPtr + rPtr) / 2;
            if(count(arr, mid) <= M)
            {
                answer = mid;  // 가능한 답을 저장하고, 더 작은 값으로 탐색
                rPtr = mid - 1;
            }
            else lPtr = mid + 1;  // 중간값이 작아서 구간 수가 M보다 많다면, 더 큰 값 탐색
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(arr, N , M));
    }
}
