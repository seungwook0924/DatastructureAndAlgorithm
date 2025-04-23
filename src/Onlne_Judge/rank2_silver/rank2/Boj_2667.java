package Onlne_Judge.rank2_silver.rank2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2667
{
    static int n;
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 배열

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answer = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int y = 0; y < n; ++y)
        {
            char[] charArray = br.readLine().toCharArray();
            for(int x = 0; x < n; ++x) map[y][x] = Character.getNumericValue(charArray[x]);
        }

        for(int y = 0; y < n; ++y)
        {
            for(int x = 0; x < n; ++x)
            {
                if(!visited[y][x] && map[y][x] != 0) // 해당 좌표에 방문하지 않았고, 집이 없는 곳이 아니라면
                    answer.add(bfs(y,x)); // bfs를 호출하여 해당 아파트 단지 집의 수를 어레이 리스트에 추가
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer); // 오름차순 정렬
        for(int count : answer) System.out.println(count);
    }

    static int bfs(int startY, int startX)
    {
        int[] dy = {1, -1, 0, 0}; // 상, 하
        int[] dx = {0, 0, -1, 1}; // 좌, 우
        visited[startY][startX] = true; // 현재 좌표는 방문 표시
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startY, startX});

        int count = 1; // 현재 좌표를 방문했으므로 1부터 시작
        while(!que.isEmpty())
        {
            int[] now = que.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i  = 0; i < 4; ++i)
            {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) continue; // 좌표 유효성 검사
                if(visited[nextY][nextX] || map[nextY][nextX] == 0) continue; // 이미 방문했거나, 집이 위치한 곳이 아니라면 pass

                que.offer(new int[] {nextY, nextX}); // 큐에 삽입
                visited[nextY][nextX] = true; // 방문 표시
                ++count; // 집의 수 증가
            }
        }
        return count; // 해당 단지의 집의 수 리턴
    }
}
