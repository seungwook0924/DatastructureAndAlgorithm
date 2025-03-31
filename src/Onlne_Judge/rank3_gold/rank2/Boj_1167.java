package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1167
{
    static class Node
    {
        int number; // 정점 번호
        int distance; // 거리

        Node(int number, int distance)
        {
            this.number = number;
            this.distance = distance;
        }
    }

    static ArrayList<Node>[] adjacencyList; // 인접 리스트
    static boolean[] visited; // 방문 배열
    static int farthestNode = 0; // 가장 멀리 있는 노드
    static int maxDistance = 0; // 가장 멀리 있는 노드의 거리

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        adjacencyList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i < n + 1; ++i) adjacencyList[i] = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());

            while(true)
            {
                int number = Integer.parseInt(st.nextToken());
                if(number == - 1) break;
                int distance = Integer.parseInt(st.nextToken());
                adjacencyList[v].add(new Node(number, distance));
            }
        }

        DFS(1, 0); // 임의의 정점(1)에서 가장 먼 정점 찾기
//         BFS(1); // 임의의 정점(1)에서 가장 먼 정점 찾기

        visited = new boolean[n + 1]; // 방문 초기화
        maxDistance = 0; // 가장 먼 거리 초기화
        DFS(farthestNode, 0); // 찾은 정점에서 가장 먼 정점까지의 거리 구하기
//        BFS(farthestNode); // 찾은 정점에서 가장 먼 정점까지의 거리 구하기

        System.out.println(maxDistance);
    }

    // 최단 거리 찾는 것이 아니므로 DFS가 유리 함
    static void DFS(int number, int distance)
    {
        visited[number] = true; // 방문 처리

        if(distance > maxDistance) // 최고 먼 거리보다 멀다면
        {
            farthestNode = number; // 가장 먼 노드 업데이트
            maxDistance = distance; // 가장 먼 거리 업데이트
        }

        for(Node next : adjacencyList[number]) // 인접 리스트 탐색
        {
            if(!visited[next.number]) // 방문 하지 않은 곳만
            {
                DFS(next.number, distance + next.distance); // 재귀 호출
            }
        }
    }

    static void BFS(int start)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0)); // 큐에 시작 노드를 넣음
        visited[start] = true; // 시작 노드 방문 처리

        while(!queue.isEmpty()) // 큐가 비어있지 않았다면
        {
            Node current = queue.poll(); // 큐에서 값을 꺼냄

            if(current.distance > maxDistance) // 최고 먼 거리보다 멀다면
            {
                farthestNode = current.number; // 가장 먼 노드 업데이트
                maxDistance = current.distance; // 가장 먼 거리 업데이트
            }

            for(Node next : adjacencyList[current.number]) // 인접 리스트 탑색
            {
                if(!visited[next.number]) // 방문하지 않았다면
                {
                    visited[next.number] = true; // 방문 처리
                    queue.offer(new Node(next.number, current.distance + next.distance)); // 큐에 삽입
                }
            }
        }
    }
}