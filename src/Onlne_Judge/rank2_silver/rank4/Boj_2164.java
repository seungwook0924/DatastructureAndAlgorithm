package Onlne_Judge.rank2_silver.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2164
{
    public static void main(String[] args) throws IOException
    {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1 ; ++i) queue.add(i);

        while (queue.size() > 1)
        {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print(queue.poll());
    }
}
