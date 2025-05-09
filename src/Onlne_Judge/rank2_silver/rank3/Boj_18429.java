package Onlne_Judge.rank2_silver.rank3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18429
{
    static int n, k, count;
    static int[] kitEffect;
    static boolean[] usedKit;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 운동 키트 개수
        k = Integer.parseInt(st.nextToken()); // 매일 빠지는 중량(근손실량)

        kitEffect = new int[n]; // 키트 사용 효과
        usedKit = new boolean[n]; // 키트를 사용했는지

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) kitEffect[i] = Integer.parseInt(st.nextToken());

        dfs(0, 500); // 시작 중량은 500

        System.out.println(count);
    }

    static void dfs(int day, int currentWeight)
    {
        if (day == n)
        {
            ++count;
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (usedKit[i]) continue; // 이미 키트를 사용했다면 pass

            int nextWeight = currentWeight - k + kitEffect[i]; // 다음 중량 = 현재 중량 - 근손실량 + 키트 사용 효과
            if (nextWeight < 500) continue; // 다음 중량이 500 미만이라면 pass

            usedKit[i] = true; // 해당 키트 사용 처리
            dfs(day + 1, nextWeight);
            usedKit[i] = false; // 다음 경우의 수 탐색을 위해 사용 처리 취소
        }
    }
}