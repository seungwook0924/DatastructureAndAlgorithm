package Algorithm.Graph.Union_Find;

public class Basic {
    static int[] parent;

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
        for (int i = 1; i < n + 1; ++i) parent[i] = i;
    }

    static void union(int a, int b)
    {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return; // 부모가 같다면 유니온 연산을 할 필요가 없음

        // 항상 더 작은 노드를 부모로 삼는다
        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }

    static int find(int node)
    {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node]); // 경로 압축
    }

    static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
