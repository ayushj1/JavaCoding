import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalancingTree {
    Node root;

    public void storeBstNodes(Node root, Vector<Node> nodes) {
        if(root == null) 
            return;

        storeBstNodes(root.left, nodes);
        nodes.add(root);
        storeBstNodes(root.right, nodes);
    }

    public Node balanceTreeUtil(Vector<Node> nodes, int start, int end) {
        if(start>end)
            return null;

        int mid = (start+end)/2;
        Node node = nodes.get(mid);

        node.left = balanceTreeUtil(nodes, start, mid-1);
        node.right = balanceTreeUtil(nodes, mid+1, end);

        return node;
    }

    public Node balanceTree(Node root) {
        Vector<Node> nodes = new Vector<Node>();
        storeBstNodes(root, nodes);
        return balanceTreeUtil(nodes, 0, nodes.size()-1);
    }

    public void preorder(Node root) {
        if(root == null)
            return;
        
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        BalancingTree bt = new BalancingTree();
        bt.root = new Node(10);
        bt.root.left = new Node(8);
        bt.root.left.left = new Node(7);
        bt.root.left.left.left = new Node(6);
        bt.root.left.left.left.left = new Node(5);

        System.out.println("Before Balancing Pre Order Traversal of Tree is: ");
        bt.preorder(bt.root);
        bt.root = bt.balanceTree(bt.root);
        System.out.println("After Balancing Pre Order Traversal of Tree is: ");
        bt.preorder(bt.root);
    }
}