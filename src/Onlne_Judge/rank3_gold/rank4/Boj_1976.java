package Onlne_Judge.rank3_gold.rank4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1976
{
    static int[] parent;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 포함된 도시 수

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) parent[i] = i;

        // 인접 행렬 입력 받고 연결된 도시끼리 union
        for (int i = 1; i < n + 1; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; ++j)
            {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) union(i, j);
            }
        }

        // 여행 계획이 가능한지 판단
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        int root = find(firstCity); // 대표 노드
        boolean possible = true;

        for (int i = 1; i < m; ++i)
        {
            int nextCity = Integer.parseInt(st.nextToken());
            if (find(nextCity) != root) // 첫 번째 노드와 다음 노드간 연결되어있지 않다면
            {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }

    static int find(int x)
    {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
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
