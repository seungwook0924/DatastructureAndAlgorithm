package Onlne_Judge.rank2_silver.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11399
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        // 선택 정렬
        for(int i = 1; i < arr.length; ++i)
        {
            int tmp = arr[i];
            int j = i - 1;

            while ((j >= 0) && (arr[j] > tmp))
            {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = tmp;
        }

        // 누적합을 모두 더함
        int sum = 0, result = 0;
        for (int i : arr)
        {
            sum += i; // 누적 합
            result += sum; // 누적합을 더함
        }
        System.out.print(result);
    }
}
