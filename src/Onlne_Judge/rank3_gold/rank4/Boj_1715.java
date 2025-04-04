package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1715
{
    public static void main(String[] args) throws IOException
    {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) pq1.offer(Integer.parseInt(br.readLine()));

        int totalSum = 0;
        while (pq1.size() > 1)
        {
            int n1 = pq1.poll();
            int n2 = pq1.poll();
            pq1.offer(n1 + n2);
            totalSum += (n1 + n2);
        }
        System.out.print(totalSum);
    }
}
