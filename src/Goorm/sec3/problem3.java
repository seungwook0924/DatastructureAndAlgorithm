package Goorm.sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long numA = Long.parseLong(st.nextToken());
            long numB = Long.parseLong(st.nextToken());

            long max = Math.max(numA, numB);
            long min = Math.min(numA, numB);

            // min * 1.6 ≤ max ≤ min * 1.63
            // max * 100 ≥ min * 160 && max * 100 ≤ min * 163 -> 정수로 바꿈(부동소수점 오차 때문)
            if ((max * 100 >= min * 160) && (max * 100 <= min * 163)) count++;
        }

        System.out.println(count);
    }
}
