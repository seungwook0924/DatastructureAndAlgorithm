package Onlne_Judge.rank3_gold.rank2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1033
{
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

    static ArrayList<Node>[] list;
    static boolean visited[];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for(int i = 0; i < n; ++i) list[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, p, q));
        }

    }
}
