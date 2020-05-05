class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class DeleteMiddleLLNode {
    public void printLL(Node node) {
        System.out.println();
        while(node.next != null) {
            System.out.print("" + node.data);
            System.out.print("->");
            node = node.next;
        }
        System.out.print("" + node.data);
    }

    public void deleteCurNode(Node curNode) {
        curNode.data = curNode.next.data;
        curNode.next = curNode.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        DeleteMiddleLLNode dmlln = new DeleteMiddleLLNode();
        dmlln.printLL(head);
        dmlln.deleteCurNode(head.next.next);
        dmlln.printLL(head);
    }
}