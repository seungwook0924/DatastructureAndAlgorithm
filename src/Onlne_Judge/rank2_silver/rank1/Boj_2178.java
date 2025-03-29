package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178
{
    static int[][] arr; // 미로
    static boolean[][] visited; // 방문 체크
    static int n;
    static int m;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        arr = new int[n][m];
        for(int i = 0; i < n; ++i)
        {
            char[] charArray = br.readLine().toCharArray(); // 문자열을 문자 배열로 변환
            for(int j = 0; j < m; ++j) arr[i][j] = Character.getNumericValue(charArray[j]); // 각 문자를 숫자로 변환하여 배열에 저장
        }

        BFS(0, 0); // (0, 0)부터 최단경로 탐색 시작
        System.out.println(arr[n - 1][m - 1]);
    }

    static void BFS(int startX, int startY)
    {
        int[] dy = { -1, 1, 0, 0 }; // y축(상, 하)
        int[] dx = { 0, 0, -1, 1 }; // x축(좌, 우)
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startY, startX}); // 큐에 시작 좌표를 넣음
        visited[startY][startX] = true; // 시작 좌표는 방문 처리

        while(!que.isEmpty()) // 큐가 비어있지 않았다면
        {
            int now[] = que.poll(); // 큐에서 좌표를 꺼냄
            int nowY = now[0]; // y좌표
            int nowX = now[1]; // x좌표

            for(int i = 0; i < 4; ++i) // 상하좌우로 다음 탐색할 좌표를 입력
            {
                int nextY = nowY + dy[i]; // 다음 탐색할 y좌표
                int nextX = nowX + dx[i]; // 다음 탐색할 x좌표

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue; // 다음 탐색할 좌표 유효성 검사
                else if (visited[nextY][nextX] || arr[nextY][nextX] == 0) continue; // 다음 탐색할 좌표가 이미 방문했거나, 벽이라면 pass
                else
                {
                    visited[nextY][nextX] = true; // 방문 표시
                    arr[nextY][nextX] = arr[nowY][nowX] + 1; // 이동한 칸 수 업데이트(BFS 깊이)
                    que.offer(new int[] {nextY, nextX}); // 큐에 삽입
                }
            }
        }
    }
}
