package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Boj_1747
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.print(func1(input));
        System.out.print(func2(input));
    }

    static boolean isPalindrome(int prime)
    {
        String stringPrime = String.valueOf(prime); // int -> string

        int leftPtr = 0;
        int rightPtr = stringPrime.length() - 1;

        while (leftPtr < rightPtr)
        {
            if (stringPrime.charAt(leftPtr) != stringPrime.charAt(rightPtr)) return false;
            ++leftPtr;
            --rightPtr;
        }
        return true;
    }

    // BigInteger 클래스 사용
    static int func1(String input)
    {
        BigInteger bigIntegerPrime = new BigInteger(input);
        if (!bigIntegerPrime.isProbablePrime(10)) bigIntegerPrime = bigIntegerPrime.nextProbablePrime(); // 입력값이 소수가 아니라면 다음 소수로 업데이트

        int answer = 0;
        while (true)
        {
            int prime = bigIntegerPrime.intValue(); // BigInteger -> int
            answer = prime; // 정답 업데이트
            if (isPalindrome(prime)) break; // 팰린드롬이라면 탈출
            bigIntegerPrime = bigIntegerPrime.nextProbablePrime(); // 다음 소수로 업데이트
        }
        return answer;
    }

    // 에라토스테네스의 체
    static int func2(String input)
    {
        int answer = 0;
        int max = 10000000;
        int n = Integer.parseInt(input);
        boolean[] isPrime = new boolean[max + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < max + 1; ++i)
            if(isPrime[i])
                for(int j = i * i; j < max + 1; j += i)
                    isPrime[j] = false;

        for(int i = n; i < max + 1; ++i)
        {
            if(isPrime[i] && isPalindrome(i))
            {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
