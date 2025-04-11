package Onlne_Judge.rank3_gold.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1016
{
    static boolean[] isSquareNoNo;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int) (max - min);

        isSquareNoNo = new boolean[size + 1];
        Arrays.fill(isSquareNoNo, true);
        arrangeIsSquareNoNo(min, max);

        int count = 0;
        for(int i = 0; i <= size; ++i) if(isSquareNoNo[i]) ++count;
        System.out.print(count);
    }

    // min ~ max 사이 숫자들 중에서, 어떤 정수의 제곱수로 나누어 떨어지는 수들을 모두 지운다.
    static void arrangeIsSquareNoNo(long min, long max)
    {
        for(long i = 2; i <= Math.sqrt(max); ++i)
        {
            long pow = i * i; // 제곱수
            long start = (min % pow == 0 ? min / pow : (min / pow) + 1); // min이 제곱수로 나누어 떨어지지 않으면 + 1부터 탐색 시작
            for (long j = start; j * pow <= max; j++) isSquareNoNo[(int) (j * pow - min)] = false;
        }
    }
}
