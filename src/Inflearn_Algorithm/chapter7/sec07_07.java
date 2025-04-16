package Inflearn_Algorithm.chapter7;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class sec07_07 {
    static Node root;

    public static void solution(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int level = 0;
        while(!que.isEmpty())
        {
            int len = que.size();
            System.out.print(level + " : ");
            for(int i = 0; i < len; ++i)
            {
                Node cur = que.poll();
                System.out.print(cur.data+" ");
                if(cur.left != null) que.add(cur.left);
                if(cur.right != null) que.add(cur.right);
            }
            ++level;
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        solution(root);
    }
}
