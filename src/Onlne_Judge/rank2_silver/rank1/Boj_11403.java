package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11403
{
    static int n;
    static int[][] adjMatrix; // 인접 행렬
    static int[][] answerMatrix; // 정답 행렬
    static boolean[] visited; // 방문 배열

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adjMatrix = new int[n][n];
        answerMatrix = new int[n][n];

        // 인접 행렬을 입력 받음
        for(int y = 0; y < n; ++y)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; ++x) adjMatrix[y][x] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; ++i)
        {
            visited = new boolean[n];
            dfs(i, i);
        }

        // 정답 행렬을 출력함
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j) System.out.print(answerMatrix[i][j] + " ");
            System.out.println();
        }
    }

    static void dfs(int startNode, int nowNode)
    {
        // 현재 정점(nowNode)에서 갈 수 있는 모든 정점을 탐색
        for(int nextNode = 0; nextNode < n; ++nextNode)
        {
            if(adjMatrix[nowNode][nextNode] == 1 && !visited[nextNode]) // 현재 정점에서 다음 정점으로의 간선이 있고 방문하지 않았다면
            {
                answerMatrix[startNode][nextNode] = 1; // 출발 정점(startNode)에서 도착 정점(nextNode)로 경로가 존재함을 기록
                visited[nextNode] = true;
                dfs(startNode, nextNode);
            }
        }
    }
}
