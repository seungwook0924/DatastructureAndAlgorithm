package inflearn_algorithm.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sec05_06 {
    public static int solution(int N, int K) {
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= N; ++i) que.add(i);

        int count = 0;
        while(que.size() > 1)
        {
            ++count;
            if(count == K)
            {
                que.poll();
                count = 0;
            }
            else que.add(que.poll());
        }
        return que.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, K));
    }
}
