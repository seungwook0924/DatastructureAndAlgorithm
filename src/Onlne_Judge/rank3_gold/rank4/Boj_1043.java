package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1043
{
    static int[] parent;
    static boolean[] knowsTruth;
    static int[][] party;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[n + 1];
        knowsTruth = new boolean[n + 1];
        party = new int[m][];

        for (int i = 1; i < n + 1; ++i) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        for (int i = 0; i < truthCount; ++i)
        {
            int person = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 번호
            knowsTruth[person] = true;
        }

        for (int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            party[i] = new int[count];

            if (count > 0) party[i][0] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < count; ++j)
            {
                party[i][j] = Integer.parseInt(st.nextToken());
                union(party[i][j - 1], party[i][j]);
            }
        }

        for (int i = 1; i < n + 1; ++i)
            if (knowsTruth[i])
                knowsTruth[find(i)] = true;

        int result = 0;
        for (int i = 0; i < m; ++i)
        {
            int representative = find(party[i][0]);
            if (!knowsTruth[representative]) ++result;
        }

        System.out.println(result);
    }

    static void union(int a, int b)
    {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return;

        // 부모가 다르다면, 두 부모 노드 중 값이 더 작은 노드가 부모 노드가 됨
        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }

    static int find(int node)
    {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
}
