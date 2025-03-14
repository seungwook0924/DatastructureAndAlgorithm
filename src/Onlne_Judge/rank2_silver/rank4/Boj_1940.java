package Onlne_Judge.rank2_silver.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1940
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n과 m을 받아옴
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 배열 생성 및 초기화
        int []arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr); // O(NlogN)
        System.out.println(func2(arr, m));
    }

    // 풀이1 for문 -> O(N^2)
    static int func1(int[] arr, int m)
    {
        int count = 0;
        for(int i = arr.length - 1; i >= 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if(arr[i] + arr[j] == m) ++count;
            }
        }
        return count;
    }

    // 풀이2 while문(시간복잡도, 공간복잡도 좋음) -> O(N)
    static int func2(int[] arr, int m)
    {
        int count = 0;
        int i = 0;
        int j = arr.length - 1;

        while (i < j)
        {
            if (arr[i] + arr[j] == m)
            {
                ++count;
                ++i;
                --j;
            }
            else if (arr[i] + arr[j] < m) ++i;
            else --j;
        }

        return count;
    }
}
