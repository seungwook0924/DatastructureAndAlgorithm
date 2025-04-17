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
    static ArrayList<Integer>[] list;
    static int[] colors;
    static final int RED = 1;
    static final int BLUE = -1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalVertex = Integer.parseInt(st.nextToken());
            int totalEdge = Integer.parseInt(st.nextToken());

            list = new ArrayList[totalVertex + 1];
            for(int j = 1; j < totalVertex + 1; ++j) list[j] = new ArrayList<>();

            for(int j = 0; j < totalEdge; ++j)
            {
                st = new StringTokenizer(br.readLine());
                int vertexA = Integer.parseInt(st.nextToken());
                int vertexB = Integer.parseInt(st.nextToken());
                list[vertexA].add(vertexB);
                list[vertexB].add(vertexA);
            }

            boolean isBipartite = true;
            for (int j = 1; j < totalVertex + 1; ++j)
            {
                if (colors[i] == 0)
                {
                    if (!bfs(i))
                    {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static boolean bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        colors[start] = RED;

        while (!que.isEmpty())
        {
            int currentNode = que.poll();
            int currentColor = colors[currentNode];

            for (int linkedNode : list[currentNode])
            {
                if (colors[linkedNode] == 0) //색이 칠해져있지 않다면
                {
                    colors[linkedNode] = -(currentColor); // 현재 노드와 색상을 반대로 설정
                    que.offer(linkedNode);
                }
                else if (colors[linkedNode] == currentColor) return false; // 현재노드와 연결된 노드의 색이 같다면 false
            }
        }

        return true;
    }
}
