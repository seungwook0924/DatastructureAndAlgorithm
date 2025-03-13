package Onlne_Judge.rank3_gold.rank3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10986
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 m을 받아옴
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 합과 나머지의 수를 저장하는 배열 생성
        long[] sumArr = new long[N + 1]; // 합 배열
        long[] remainArr = new long[M]; // 합 배열을 M으로 나눴을 때 나머지의 수를 저장하는 배열 -> 나머지 배열과 다름
        long count = 0;

        // 합 배열 및 나머지의 수를 저장하는 배열을 구함
        // 1차적으로 값을 구함
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sumArr.length; ++i)
        {
            sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i - 1];
            int remainder = (int) (sumArr[i] % M); // 합 배열을 M으로 나눈 값
            if(remainder == 0) ++count; // 나머지가 0인 개수를 카운트
            ++remainArr[remainder]; // 나머지의 수를 저장하는 배열의 '합 배열을 M으로 나눈 값'을 인덱스로 가지는 값을 증가시킴
        }

        // 나머지 배열에서 원소 값이 같은 개수를 더함(조합)
        // 원소 값이 같은 2개의 원소를 뽑는 모든 경우의 수
        for(int i = 0; i < M; ++i)
        {
            if(remainArr[i] > 1) count += (remainArr[i] * (remainArr[i] - 1) / 2);
        }

        System.out.println(count);
    }
}