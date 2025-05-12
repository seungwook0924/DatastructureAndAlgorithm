package Goorm.sec13;

import java.io.*;
import java.util.*;

public class Problem2 {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];
        int[][] fire = new int[R][C];
        for (int[] row : fire) Arrays.fill(row, -1);

        Deque<int[]> q = new ArrayDeque<>();
        int sy = -1, sx = -1;   // 구름이 위치

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);
                grid[r][c] = ch;
                if (ch == '@') {
                    fire[r][c] = 0;
                    q.add(new int[]{r, c});
                } else if (ch == '&') {
                    sy = r;
                    sx = c;
                }
            }
        }

        // 다중 BFS로 불 전파 시간 계산
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (grid[nr][nc] == '#' || fire[nr][nc] != -1) continue;
                fire[nr][nc] = fire[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }

        // 구름이 인접 4칸 중 최소 불도착 시간 탐색
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            int nr = sy + dr[d], nc = sx + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (grid[nr][nc] == '#') continue;
            if (fire[nr][nc] == -1) continue;   // 끝까지 불이 안 옴
            ans = Math.min(ans, fire[nr][nc]);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}