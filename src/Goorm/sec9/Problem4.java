package Goorm.sec9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem4
{
    public static boolean[] sieve(int n)
    {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // 처음엔 전부 소수(true)로 가정
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; ++i)
        {
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false; // i의 배수 제거
        }
        return isPrime;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        int max = 0;

        // 입력값 저장 및 최대값 계산
        for(int i = 0; i < n; ++i)
        {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > max) max = inputs[i];
        }

        boolean[] isPrime = sieve(max);

        for (int i = 0; i < n; i++)
        {
            int count = 0;
            while (!isPrime[inputs[i] - count]) count++; // 소수가 아닐 때마다 갑옷 변형 시스템을 1회 사용
            sb.append(count).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
