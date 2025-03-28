package Onlne_Judge.rank3_gold.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2023
{
    static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int digit)
    {
        if(digit == n)
        {
            if(isPrime(num)) System.out.println(num);
            return;
        }
        for(int i = 1; i < 10; ++i)
        {
            if(i % 2 == 0) continue; // 짝수라면 더 이상 탐색할 필요 없음
            if(isPrime(num * 10 + i)) DFS(num * 10 + i, digit + 1); // 소수라면 자릿수를 늘리고, 재귀 호출
        }
    }

    static boolean isPrime(int num)
    {
        for(int i = 2; i <= num / 2; ++i) if(num % i == 0) return false;
        return true;
    }
}
