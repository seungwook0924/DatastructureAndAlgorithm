package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1260
{
    static ArrayList<Integer>[] adjacencyList; // 인접 리스트
    static boolean[] visited; // 방문 체크

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int start = Integer.parseInt(st.nextToken()); // 시작 노드

        visited = new boolean[n + 1];
        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i < adjacencyList.length; ++i) adjacencyList[i] = new ArrayList<>();

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjacencyList[v1].add(v2);
            adjacencyList[v2].add(v1);
        }

        for(int i = 1; i < n + 1; ++i) Collections.sort(adjacencyList[i]); // 각 인접 리스트를 정렬

        DFS(start);
        System.out.println();
        visited = new boolean[n + 1]; // 방문 배열 초기화
        BFS(start);
    }

    static void DFS(int num)
    {
        visited[num] = true;
        System.out.print(num + " ");
        for(int i : adjacencyList[num]) if(!visited[i]) DFS(i);
    }

    static void BFS(int start)
    {
        LinkedList<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while(!que.isEmpty())
        {
            int value = que.poll();
            System.out.print(value + " ");

            for(int i : adjacencyList[value])
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
