package Onlne_Judge.rank3_gold.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1456
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = (int)Math.sqrt(b) + 1; // 진짜 소수를 찾는 것이 아니기 때문에 많은 배열이 필요없다.
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체
        for(int i = 2; i * i < max; i++)
            if(isPrime[i])
                for(int j = i * i; j < max; j += i)
                    isPrime[j] = false;

        // 거의 소수를 카운트
        int count = 0;
        for (int i = 2; i < max; ++i)
        {
            if (!isPrime[i]) continue;
            long value = (long) i * i;
            while (value <= b)
            {
                if (value >= a) ++count;
                if (value > b / i) break; // 오버플로우 방지 value * i > b --> value > b / i
                value *= i;
            }
        }


        System.out.print(count);
    }
}
