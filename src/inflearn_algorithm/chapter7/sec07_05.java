package inflearn_algorithm.chapter7;

import java.io.IOException;

class Node{
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}

public class sec07_05 {

    //전위 순회
    public static void preorder(Node node)
    {
        if(node==null) return;
        else
        {
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    //중위 순회
    public static void postorder(Node node)
    {
        if(node==null) return;
        else
        {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data+" ");
        }
    }

    //후위 순회
    public static void inorder(Node node)
    {
        if(node==null) return;
        else
        {
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) throws IOException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}
