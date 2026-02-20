package Onlne_Judge.rank2_silver.rank3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1004 {
    static boolean inside(int x, int y, int cx, int cy, int r) {
        long dx = (long) x - cx;
        long dy = (long) y - cy;
        long dist2 = dx * dx + dy * dy;
        long r2 = (long) r * r;
        return dist2 < r2; // 경계 위는 내부로 보지 않음
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine().trim());
            int ans = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r  = Integer.parseInt(st.nextToken());

                boolean sIn = inside(x1, y1, cx, cy, r);
                boolean eIn = inside(x2, y2, cx, cy, r);

                if (sIn != eIn) ans++;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
