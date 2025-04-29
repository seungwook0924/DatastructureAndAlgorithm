package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2251
{
    static class State
    {
        int a, b, c;
        State(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static boolean[][][] visited; // 상태 방문 체크
    static boolean[] result; // C에 남을 수 있는 물의 양 기록
    static int[] limit; // 각 물통의 최대 용량 (A, B, C)

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limit = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) limit[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[limit[0] + 1][limit[1] + 1][limit[2] + 1];
        result = new boolean[limit[2] + 1];

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= limit[2]; i++) if (result[i]) sb.append(i).append(' ');
        System.out.println(sb);
    }

    static void bfs()
    {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, limit[2]));
        visited[0][0][limit[2]] = true;

        while (!queue.isEmpty())
        {
            State current = queue.poll();

            // A가 비어있을 때 C에 남아 있는 물 기록
            if (current.a == 0) result[current.c] = true;

            // 0: A, 1: B, 2: C
            for (int from = 0; from < 3; from++)
            {
                for (int to = 0; to < 3; to++)
                {
                    if (from == to) continue; // 같은 통끼리는 이동 불가

                    int[] next = { current.a, current.b, current.c };

                    // from → to 로 물을 옮긴다
                    int amount = Math.min(next[from], limit[to] - next[to]);
                    next[from] -= amount;
                    next[to] += amount;

                    if (!visited[next[0]][next[1]][next[2]])
                    {
                        visited[next[0]][next[1]][next[2]] = true;
                        queue.add(new State(next[0], next[1], next[2]));
                    }
                }
            }
        }
    }
}
