package Goorm.sec11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4
{
    static final int MAXN = 100001;
    static int[] parent = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M 입력 처리
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 처음에는 자기 자신을 부모로 가지게끔 한다.
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int ct = N; // 처음엔 N개의 집합이 있다.

        // 간선 정보 입력 및 처리
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            if (union(a, b)) { // a와 b가 합쳐진다면
                --ct; // 집합의 개수는 하나 줄어든다.
            }
        }

        // 결과 출력
        System.out.println(ct);
    }

    // find 함수: 루트 노드를 찾는다 (경로 압축 기법 적용)
    static int find(int u) {
        if (parent[u] != u) { // 현재 자신과 자신의 부모가 같지 않다면 자신이 집합의 루트가 아니라는 것이다.
            parent[u] = find(parent[u]); // 재귀적으로 루트를 찾아서 부모 노드를 루트로 갱신한다.
        }
        return parent[u]; // 루트 노드를 반환한다.
    }

    // merge 함수: 두 집합을 합친다 (Union by rank 기법 적용)
    static boolean union(int u, int v) {
        // 합치고자 하는 두 노드가 속해 있는 집합의 루트를 구한다.
        int root_u = find(u);
        int root_v = find(v);

        // 루트가 같다면 집합이 이미 같다는 뜻이다.
        if (root_u == root_v) {
            return false;
        }

        // 루트가 다르다면 루트의 번호가 큰 쪽이 작은 쪽의 집합 밑으로 들어가게 한다.
        if (root_u < root_v) {
            parent[root_v] = root_u;
        } else {
            parent[root_u] = root_v;
        }
        return true;
    }
}
