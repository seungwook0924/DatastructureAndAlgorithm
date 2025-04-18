package Goorm.sec5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] hp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) hp[i] = Integer.parseInt(st.nextToken());

        int attackCount = 0;
        for (int i = 0; i < n; ++i)
        {
            while (hp[i] > 0)
            {
                attackCount++;
                int damage = (attackCount - 1) % 4 + 1;
                hp[i] -= damage;
            }
        }

        System.out.println(attackCount);
    }
}
