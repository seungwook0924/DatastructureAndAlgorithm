package Onlne_Judge.rank3_gold.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1016
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int count = 0;
        for (long i = min; i <= max; ++i)
        {
            boolean isSquareFree = true;
            for (long j = 2; j * j <= max; ++j)
            {
                long square = j * j;
                if (i % square == 0)
                {
                    isSquareFree = false;
                    break;
                }
            }

            if (isSquareFree) ++count;
        }
        System.out.print(count);
    }
}
