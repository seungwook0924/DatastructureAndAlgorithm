package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1715
{
    public static void main(String[] args) throws IOException
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) pq.offer(Integer.parseInt(br.readLine()));

        int totalSum = 0;
        while (pq.size() > 1)
        {
            int n1 = pq.poll();
            int n2 = pq.poll();
            pq.offer(n1 + n2);
            totalSum += (n1 + n2);
        }
        System.out.print(totalSum);
    }
}
