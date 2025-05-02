package Onlne_Judge.rank2_silver.rank1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_24542
{
    static int[] parent;
    static int[] size;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        long result = 1;
        for (int i = 1; i <= n; i++) if (parent[i] == i) result = (result * size[i]) % MOD;

        System.out.println(result);
    }

    static int find(int x)
    {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y)
    {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return;

        if (size[rx] < size[ry])
        {
            parent[rx] = ry;
            size[ry] += size[rx];
        }
        else
        {
            parent[ry] = rx;
            size[rx] += size[ry];
        }
    }
}
