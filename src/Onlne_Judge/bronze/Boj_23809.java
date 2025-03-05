package Onlne_Judge.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_23809
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        func(N, 3, sb);
        func(N, 2, sb);
        func(N, 0, sb);
        func(N, 2, sb);
        func(N, 3, sb);
        System.out.println(sb);
    }

    static void func(int n, int blank, StringBuilder sb)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; ++j) sb.append('@');
            for (int j = 0; j < blank*n; ++j) sb.append(' ');
            for (int j = 0; j < n; ++j) sb.append('@');
            if (blank == 0) for (int j = 0; j < n; ++j) sb.append('@');
            sb.append('\n');
        }
    }
}
