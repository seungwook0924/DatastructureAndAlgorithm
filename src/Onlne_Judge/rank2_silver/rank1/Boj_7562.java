package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7562
{
    static int[][] board; // 최단 경로 배열
    static boolean[][] visited; // 방문 배열
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // 나이트가 이동할 수 있는 x좌표
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1}; // 나이트가 이동할 수 있는 y좌표

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < t; ++i)
        {
            int l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());

            board = new int[l][l];
            visited = new boolean[l][l];

            int answer = bfs(l, fromX, fromY, toX, toY); // BFS 탐색
            sb.append(answer).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    static int bfs(int l, int fromX, int fromY, int toX, int toY)
    {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{fromY, fromX}); // 시작 좌표를 큐에 추가
        visited[fromY][fromX] = true; // 방문 처리
        board[fromY][fromX] = 0; // 시작 좌표의 거리는 0

        while (!que.isEmpty())
        {
            int[] current = que.poll();
            int currentY = current[0];
            int currentX = current[1];

            if (currentX == toX && currentY == toY) return board[currentY][currentX]; // 목표 좌표에 도달했다면

            for (int dir = 0; dir < 8; ++dir)
            {
                int nextY = currentY + dy[dir]; // 다음 y좌표
                int nextX = currentX + dx[dir]; // 다음 x좌표

                if (nextX >= 0 && nextY >= 0 && nextX < l  && nextY < l && !visited[nextY][nextX]) // 좌표 유효성 검사
                {
                    visited[nextY][nextX] = true; // 방문 처리
                    board[nextY][nextX] = board[currentY][currentX] + 1; // 거리 업데이트
                    que.offer(new int[]{nextY, nextX}); // 큐에 추가
                }
            }
        }

        return -1;
    }
}
