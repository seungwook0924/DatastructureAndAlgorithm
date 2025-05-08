package Algorithm.Graph.Union_Find;

public class Rank
{
    static int[] parent;
    static int[] rank; // 트리의 깊이를 저장하는 배열

    public static void main(String[] args)
    {
        init(5);

        union(1, 2);
        union(3, 4);

        System.out.println(isConnected(1, 2)); // true
        System.out.println(isConnected(2, 3)); // false

        union(2, 3);
        System.out.println(isConnected(1, 4)); // true
    }

    static void init(int n)
    {
        parent = new int[n + 1];
        rank = new int[n + 1]; // 모든 rank를 0으로 초기화

        for (int i = 1; i < n + 1; ++i)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static void union(int a, int b)
    {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return;

        // rank를 비교하여 더 낮은 트리를 더 높은 트리에 붙임
        if (rank[parentA] < rank[parentB]) parent[parentA] = parentB;
        else if (rank[parentA] > rank[parentB]) parent[parentB] = parentA;
        else
        {
            parent[parentB] = parentA;
            rank[parentA]++; // 깊이가 같으면 한 쪽으로 붙이고, 그 쪽의 rank 증가
        }
    }

    static int find(int node)
    {
        if (parent[node] != node) parent[node] = find(parent[node]); // 경로 압축
        return parent[node];
    }

    static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
