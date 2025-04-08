package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1541
{
    /*
        10+20-30+40-50+60 = 10+20-(30+40)-(50+60)
        = 10+20-(30+40+50+60)
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE; // 첫 번째 토큰 체크용으로 MAX_VALUE로 초기화
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-"); // '-'기준으로 토큰을 나눔

        while (minus.hasMoreTokens()) // 다음 토큰이 존재한다면
        {
            int temp = 0;
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+"); // '-'으로 나뉜 토큰을 다시 '+'으로 분리

            while (plus.hasMoreTokens()) temp += Integer.parseInt(plus.nextToken()); // 해당 토큰들을 모두 더함
            if (sum == Integer.MAX_VALUE) sum = temp; // 첫 번째 토큰인 경우 더함
            else sum -= temp; // 첫 번째 토큰이 아닐경우 모두 뺌
        }
        System.out.print(sum);
    }
}
