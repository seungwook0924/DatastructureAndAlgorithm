package Onlne_Judge.rank3_gold.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10986
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m을 받아옴
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 합 배열과 나머지를 저장하는 배열 생성
        long[] sumArr = new long[N + 1];
        long[] remainArr = new long[M];
        long count = 0;

        // 합 배열 및 나머지 배열을 구함
        // 1차적으로 값을 구함
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sumArr.length; ++i)
        {
            sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i - 1];
            int remainder = (int) (sumArr[i] % M);
            if(remainder == 0) ++count; // 나머지가 0인 개수를 카운트
            ++remainArr[remainder];
        }

        for(int i = 0; i < M; ++i)
        {
            if(remainArr[i] >= 2) count += (remainArr[i] * (remainArr[i] - 1) / 2);
        }

        System.out.println(count);
    }
}