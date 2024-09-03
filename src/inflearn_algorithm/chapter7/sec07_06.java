package inflearn_algorithm.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sec07_06 {
    static int N;
    static int[] ch;
    static StringBuilder sb;
    public static void solution(int L) {
        if(L == N + 1)
        {
            sb = new StringBuilder("");
            for(int i = 1; i <= N; ++i) if(ch[i]==1) sb.append(i).append(" ");
            if(!sb.isEmpty()) System.out.println(sb);
        }
        else
        {
            ch[L] = 1;
            solution(L + 1);
            ch[L] = 0;
            solution(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ch = new int[N + 1];
        solution(1);
    }
}
