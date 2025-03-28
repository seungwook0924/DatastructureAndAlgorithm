package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11724
{
    static ArrayList<Integer>[] adjacencyList; // 인접 리스트
    static boolean[] visited; // 방문 체크

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 엣지 개수

        adjacencyList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i < n + 1; ++i) adjacencyList[i] = new ArrayList<>(); // 인접 리스트 초기화

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacencyList[u].add(v); // 인접 리스트에 추가
            adjacencyList[v].add(u); // 인접 리스트에 추가
        }

        int count = 0;
        for(int i = 1; i < n + 1; ++i)
        {
            if(!visited[i])
            {
                ++count;
                DFS(i);
            }
        }
        System.out.print(count);
    }

    static void DFS(int v)
    {
        visited[v] = true;
        for(int i : adjacencyList[v]) if(!visited[i]) DFS(i);
    }
}
