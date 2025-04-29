package Goorm.sec10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        long answer = 0;

        for (int i = 0; i < n - 2; ++i)
        {
            for (int j = i + 1; j < n - 1; ++j)
            {
                long sum = arr[i] + arr[j];
                int index = Arrays.binarySearch(arr, sum); // sum 값의 인덱스를 저장

                if (index < 0) index = -(index) - 1; // sum을 발견하지 못했다면 부호를 반대로 바꾸고 -1
                else ++index; // 인덱스를 1 증가(자기 자신은 포함 안하기 때문)

                if (index > j + 1) answer += (index - (j + 1));
            }
        }
        System.out.println(answer);
    }
}
