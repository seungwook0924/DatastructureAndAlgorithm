package Onlne_Judge.rank2_silver.rank2;

import java.io.*;
import java.util.*;

public class Boj_2644
{
    static ArrayList<Integer>[] list; // 인접 리스트
    static boolean[] visited; // 방문 배열
    static int[] depth; // 깊이(촌수) 배열

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; ++i) list[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[parent].add(child); // 양방향
            list[child].add(parent); // 양방향
        }

        System.out.print(bfs(start, target));
    }

    static int bfs(int start, int target)
    {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;

        while (!que.isEmpty())
        {
            int now = que.poll();
            if (now == target) return depth[now];

            for(int next : list[now])
            {
                if(!visited[next])
                {
                    visited[next] = true; // 방문 표시
                    depth[next] = depth[now] + 1; // 깊이(촌수) 업데이트
                    que.offer(next);
                }
            }
        }

        return -1;
    }
}
