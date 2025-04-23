package Goorm.sec8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1_2
{
    static int[] digits;
    static long k;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        digits = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) digits[i] = Integer.parseInt(st.nextToken());

        k = Long.parseLong(br.readLine());

        Arrays.sort(digits);
        int maxLength = String.valueOf(k).length() + 1;

        for (int len = String.valueOf(k).length(); len <= maxLength; ++len) dfs("", len);

        System.out.println(answer);
    }

    static void dfs(String current, int targetLength)
    {
        if (!current.isEmpty())
        {
            long num = Long.parseLong(current);
            if (num > answer) return;

            if (current.length() == targetLength)
            {
                if (num > k && num < answer) answer = num;
                return;
            }
        }

        for (int i = 0; i < digits.length; ++i)
        {
            if (current.isEmpty() && digits[i] == 0) continue;
            dfs(current + digits[i], targetLength);
        }
    }
}
