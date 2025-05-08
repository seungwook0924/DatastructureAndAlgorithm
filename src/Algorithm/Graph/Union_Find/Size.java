package Algorithm.Graph.Union_Find;

public class Size {
    static int[] parent;
    static int[] size;

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
        size = new int[n + 1];
        for (int i = 1; i < n + 1; ++i)
        {
            parent[i] = i;
            size[i] = 1;
        }
    }

    static void union(int a, int b)
    {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return; // 이미 같은 집합이면 병합 불필요

        // 더 작은 집합을 큰 집합에 붙인다
        if (size[parentA] < size[parentB])
        {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
        else
        {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
    }

    static int find(int node)
    {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]); // 경로 압축
    }

    static boolean isConnected(int a, int b)
    {
        return find(a) == find(b);
    }
}
