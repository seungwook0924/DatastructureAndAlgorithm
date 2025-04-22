package Goorm.sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        int sum = (2 * arr.length) + arr[0] + arr[arr.length - 1]; // (울타리 총 너비 * 2) + 좌측 울타리 높이 + 우측 울타리 높이

        // 울타리 사이 너비
        for(int i = 1; i < n; ++i)
        {
            if(arr[i] > arr[i - 1]) sum += arr[i] - arr[i - 1];
            else sum += arr[i - 1] - arr[i];
        }

        System.out.println(sum);
    }
}
