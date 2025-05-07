package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_24542
{
    static int[] parent; // 대표 노드를 저장하는 배열
    static int[] size; // 어떤 인덱스가 루트일 때, 연결된 정점의 수를 저장하는 배열
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; ++i)
        {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        /*
        각 무리마다 대표 한 명(튜터)을 고를 수 있는 방법의 수 = 그 무리의 인원 수
        전체에서 가능한 방법의 수 = 각 무리의 경우의 수를 모두 곱한 것
        ex) 3개의 무리가 있고, 각각 2, 3, 4명이 있는데, 각 무리에서 한 명의 대표를 뽑는다고 하면 2 x 3 x 4 = 24
         */
        long result = 1;
        for (int i = 1; i < n + 1; ++i)
            if (parent[i] == i) // i 자신이 대표 노드라면(i가 한 무리의 대표인지 확인)
                result = (result * size[i]) % MOD; // 모든 연결 요소의 크기를 곱해서 전체 경우의 수를 구하고 MOD로 나눈다.(이 무리에서 튜터를 뽑는 방법이 size[i]가지가 있다는 뜻)

        System.out.println(result);
    }

    static int find(int x)
    {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y)
    {
        // 대표 노드를 찾음
        int rootX = find(x);
        int rootY = find(y);

        // 루트가 같은 경우는 무시
        if (rootX == rootY) return;

        // 사이즈 기준 병합(작은 집합을 큰 집합에 붙임)
        if (size[rootX] < size[rootY])
        {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        else
        {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}
