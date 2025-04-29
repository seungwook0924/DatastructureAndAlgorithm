package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1707
{
    static ArrayList<Integer>[] list; // 인접 리스트
    static int[] colors; // 색상 배열

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalVertex = Integer.parseInt(st.nextToken()); // 총 정점 수
            int totalEdge = Integer.parseInt(st.nextToken()); // 총 간선 수

            // 인접 리스트 초기화
            list = new ArrayList[totalVertex + 1];
            for(int j = 1; j < totalVertex + 1; ++j) list[j] = new ArrayList<>();

            colors = new int[totalVertex + 1]; // 색상 배열 초기화

            for(int j = 0; j < totalEdge; ++j)
            {
                st = new StringTokenizer(br.readLine());
                int vertexA = Integer.parseInt(st.nextToken());
                int vertexB = Integer.parseInt(st.nextToken());
                list[vertexA].add(vertexB); // 양방향
                list[vertexB].add(vertexA); // 양방향
            }

            boolean flag = true;
            for (int j = 1; j < totalVertex + 1; ++j)
            {
                if (colors[j] == 0) // 색이 정해지지 않았다면
                {
                    if (!bfs(j)) // 이분 그래프가 아니라면
                    {
                        flag = false;
                        break;
                    }
                }
            }
            sb.append(flag ? "YES" : "NO").append(System.lineSeparator());
        }

        System.out.print(sb);
    }

    static boolean bfs(int start)
    {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start); // 시작 정점을 큐에 넣음
        colors[start] = 1; // 빨강은 1, 파랑은 -1

        while (!que.isEmpty())
        {
            int currentNode = que.poll(); // 큐에 가장 앞에 있는 정점을 가져옴
            int currentColor = colors[currentNode]; // 그 정점의 색을 가져옴

            for (int linkedNode : list[currentNode])
            {
                if (colors[linkedNode] == 0) //색이 칠해져있지 않다면
                {
                    colors[linkedNode] = -(currentColor); // 현재 노드와 색상을 반대로 설정
                    que.offer(linkedNode); // 큐에 삽입
                }
                else if (colors[linkedNode] == currentColor) return false; // 현재노드와 연결된 노드의 색이 같다면 false
            }
        }

        return true; // 연결된 노드를 모두 순회했다면 true
    }
}
