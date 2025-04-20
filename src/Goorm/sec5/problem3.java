package Goorm.sec5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    static int N;
    static int[] hp = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) hp[i] = Integer.parseInt(st.nextToken());

        long answer = 0;
        int attackCount = 0;

        for (int i = 0; i < N; ++i)
        {
            while (hp[i] > 0)
            {
                // 공격 횟수가 0 그리고 체력이 10 이상이라면
                if ((attackCount == 0) && (hp[i] >= 10))
                {
                    int cycle = hp[i] / 10;
                    hp[i] -= cycle * 10;
                    answer += cycle * 4;
                }
                else // 공격횟수가 0이 아니거나 체력이 10 미만일 때
                {
                    hp[i] -= attackCount + 1;
                    attackCount = (attackCount + 1) % 4;
                    ++answer;
                }
            }
        }

        System.out.print(answer);
    }
}
