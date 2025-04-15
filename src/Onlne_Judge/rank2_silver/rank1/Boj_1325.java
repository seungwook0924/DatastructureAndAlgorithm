package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1325
{
    static ArrayList<Integer>[] list;
    static int[] count;
    static int n;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i) list[i] = new ArrayList<>();

        for (int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int computerA = Integer.parseInt(st.nextToken());
            int computerB = Integer.parseInt(st.nextToken());
            list[computerB].add(computerA); // b를 해킹하면 a도 해킹 가능
        }

        // n개의 컴퓨터를 BFS 탐색하여 해킹할 수 있는 컴퓨터의 수를 계산
        count = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) count[i] = bfs(i);

        // 최댓값 탐색
        int max = Arrays.stream(count).max().getAsInt();
        for (int i = 1; i < n + 1; ++i)
            if (count[i] == max)
                sb.append(i).append(" ");

        System.out.println(sb);
    }

    static int bfs(int start)
    {
        boolean[] visited = new boolean[n + 1]; // 방문을 하였는지 저장하는 배열
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        int cnt = 0; // 연결된 컴퓨터를 저장하는 변수

        while (!que.isEmpty())
        {
            int currentComputer = que.poll();

            for (int linkedComputer : list[currentComputer]) // 연결된(인접 리스트에 저장된) 컴퓨터를 순회
            {
                if (!visited[linkedComputer]) // 만약 방문하지 않았다면
                {
                    visited[linkedComputer] = true;
                    que.offer(linkedComputer);
                    ++cnt; // 연결된 컴퓨터 수 증가
                }
            }
        }

        return cnt;
    }
}

