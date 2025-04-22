package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012
{
    static int[][] farm;
    static boolean[][] visited;
    static int[] dy = { 1, -1, 0, 0 }; // y축(상, 하)
    static int[] dx = { 0, 0, -1, 1 }; // x축(좌, 우)

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 농장 가로 길이
            int n = Integer.parseInt(st.nextToken()); // 농장 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추의 수

            int count = 0;
            farm = new int[n][m]; // [세로][가로]
            visited = new boolean[n][m];
            for(int j = 0; j < k; ++j)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1; // 배추 심기
            }

            for(int y = 0; y < n; ++y)
                for(int x = 0; x < m; ++x)
                    if(bfs(y, x)) ++count; // bfs 탐색 시작

            System.out.println(count); // 결과 출력
        }

    }

    static boolean bfs(int startY, int startX)
    {
        if (visited[startY][startX] || farm[startY][startX] == 0) return false; // 이미 방문했거나 배추가 심어지지 않은 곳은 pass
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startY, startX});
        visited[startY][startX] = true; // 현재 위치 방문 표시

        while(!que.isEmpty())
        {
            int[] now = que.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 상 -> 하 -> 좌 -> 우 순으로 이동
            for(int i = 0; i < 4; ++i)
            {
                int nextY = nowY + dy[i]; // 다음 이동 y좌표 설정
                int nextX = nowX + dx[i]; // 다음 이동 x좌표 설정

                if (nextY < 0 || nextX < 0 || nextY >= farm.length || nextX >= farm[0].length) continue; // 좌표 유효성 검사
                if (visited[nextY][nextX] || farm[nextY][nextX] == 0) continue; // 이미 방문했거나, 배추가 없다면 pass

                visited[nextY][nextX] = true; // 방문 표시
                que.offer(new int[] {nextY, nextX}); // 큐에 추가
            }
        }
        return true;
    }
}
