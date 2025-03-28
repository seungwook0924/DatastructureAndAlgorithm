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
    static int[] dy = { -1, 1, 0, 0 }; // y축(상, 하)
    static int[] dx = { 0, 0, -1, 1 }; // x축(좌, 우)
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
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0; j < m; ++j) arr[i][j] = Character.getNumericValue(charArray[j]);
        }

        BFS(0, 0);
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j) System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println(arr[n - 1][m - 1]);
    }

    static void BFS(int startX, int startY)
    {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startY, startX});
        visited[startY][startX] = true;

        while(!que.isEmpty())
        {
            int now[] = que.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i = 0; i < 4; ++i)
            {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue; // 좌표 유효성 검사
                if (visited[nextY][nextX] || arr[nextY][nextX] == 0) continue; // 이미 방문했거나, 벽이라면 pass

                visited[nextY][nextX] = true; // 방문 표시
                arr[nextY][nextX] = arr[nowY][nowX] + 1; // 이동한 칸 수 업데이트
                que.offer(new int[] {nextY, nextX}); // 큐에 삽입
            }
        }
    }
}
