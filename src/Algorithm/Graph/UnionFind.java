package Algorithm.Graph;

public class UnionFind {
    static int[] parent;

    public static void main(String[] args) {
        init(5);

        union(1, 2);
        union(3, 4);

        System.out.println(isConnected(1, 2)); // true
        System.out.println(isConnected(2, 3)); // false

        union(2, 3);
        System.out.println(isConnected(1, 4)); // true
    }

    static void init(int n) {
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) parent[i] = i;
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // 항상 더 작은 노드를 부모로 삼는다
        if (rootX < rootY) parent[rootY] = rootX;
        else parent[rootX] = rootY;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
