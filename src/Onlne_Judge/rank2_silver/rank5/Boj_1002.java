package Onlne_Judge.rank2_silver.rank5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;

            int distSq = dx * dx + dy * dy;           // 중심 거리 제곱
            int sumSq = (r1 + r2) * (r1 + r2);        // 반지름 합 제곱
            int diffSq = (r1 - r2) * (r1 - r2);       // 반지름 차 제곱

            // 중심 같음
            if (distSq == 0) {
                if (r1 == r2) sb.append(-1).append("\n");
                else sb.append(0).append("\n");
            }
            // 외접 or 내접
            else if (distSq == sumSq || distSq == diffSq) {
                sb.append(1).append("\n");
            }
            // 두 점에서 만남
            else if (distSq < sumSq && distSq > diffSq) {
                sb.append(2).append("\n");
            }
            // 만나지 않음
            else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}
