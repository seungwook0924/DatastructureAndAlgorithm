package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1033
{
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static long[] ratio;
    static int n;

    static class Node
    {
        int toNode;
        int p;
        int q;

        public Node(int toNode, int p, int q)
        {
            this.toNode = toNode;
            this.p = p;
            this.q = q;
        }
    }

    // 최대공약수
    static long getGCD(long a, long b)
    {
        if(b == 0) return a;
        else return getGCD(b, a % b);
    }

    // 최소공배수
    static long getLCM(long a, long b)
    {
        return a * b / getGCD(a, b);
    }

    static void dfs(int i)
    {
        visited[i] = true;

        for (Node node : list[i])
        {
            if (!visited[node.toNode])
            {
                ratio[node.toNode] = ratio[i] * node.q / node.p;
                dfs(node.toNode);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for (int i = 0; i < n; ++i) list[i] = new ArrayList<>();
        ratio = new long[n];
        visited = new boolean[n];

        long lcm = 1;

        for (int i = 0; i < n - 1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, p, q));
            list[b].add(new Node(a, q, p)); // 양방향 추가

            long pqLCM = getLCM(p, q); // p와 q의 최소공배수를 구함
            lcm = getLCM(lcm, pqLCM); // 이전 최소 공배수와 현재 최소공배수의 최소공배수를 구함
        }

        ratio[0] = lcm;
        dfs(0);

        long gcd = ratio[0];
        for (int i = 1; i < n; ++i) gcd = getGCD(gcd, ratio[i]);
        for (int i = 0; i < n; ++i) sb.append(ratio[i] / gcd).append(" ");

        System.out.println(sb);
    }
}
