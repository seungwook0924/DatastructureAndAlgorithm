package Onlne_Judge.rank3_gold.rank5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1717
{
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원소 수
        int m = Integer.parseInt(st.nextToken()); // 연산 수

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) parent[i] = i; // 자기 자신으로 초기화

        for (int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            if (cmd == 0) union(nodeA, nodeB);
            else
            {
                if (find(nodeA) == find(nodeB)) sb.append("YES").append(System.lineSeparator());
                else sb.append("NO").append(System.lineSeparator());
            }
        }

        System.out.print(sb);
    }

    static int find(int value)
    {
        if (parent[value] != value) parent[value] = find(parent[value]);
        return parent[value];
    }

    static void union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
        {
            if (rootA < rootB) parent[rootB] = rootA;
            else parent[rootA] = rootB;
        }
    }
}
