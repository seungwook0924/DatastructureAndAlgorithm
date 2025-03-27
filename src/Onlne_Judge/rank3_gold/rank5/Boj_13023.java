package Onlne_Judge.rank3_gold.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023
{
    static boolean[] visited; // 방문 배열
    static ArrayList<Integer>[] adjacencyList; // 인접 리스트

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 엣지 개수

        visited = new boolean[n];
        adjacencyList = new ArrayList[n];
        for(int i = 0; i < adjacencyList.length; ++i) adjacencyList[i] = new ArrayList<>();

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            adjacencyList[v].add(u);
            adjacencyList[u].add(v);
        }

        for(int i = 0; i < n; ++i)
        {
            if(!visited[i])
            {
                if (DFS(i, 1))
                {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    static boolean DFS(int num, int depth)
    {
        System.out.print(num + "(depth " + depth +") -> ");
        if(depth == 5) return true; // 깊이가 5라면 메서드 종료 및 true 리턴
        visited[num] = true; // 방문 처리
        for(int i : adjacencyList[num]) // 해당 인접 리스트 순회
        {
            if((!visited[i]) && (DFS(i, depth + 1))) return true; // 재귀의 리턴 값이 ture 라면 true 리턴
        }
        System.out.println();
        // 메서드가 종료되지 않았다면(true를 리턴받지 못했다면)
        visited[num] = false; // 방문 처리 취소(다른 경로에서 num을 방문할 수 있도록)
        return false;
    }
}
