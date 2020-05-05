import java.util.HashMap;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class FindLoop {
    public void printLLInLoop(Node node) {
        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        System.out.println();
        while(!hm.containsKey(node.data)) {
            System.out.print("" + node.data);
            System.out.print("->");
            hm.put(node.data, true);
            node = node.next;
        }
        System.out.print("" + node.data);
        System.out.println();
    }

    public int findLoopStartPoint(Node node) {
        Node slowPtr = node;
        Node fastPtr = node;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr) {
                break;
            }
        }

        if(fastPtr == null || fastPtr.next == null) {
            return -1;
        }

        slowPtr = node;
        while(slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return fastPtr.data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;

        FindLoop fl = new FindLoop();
        
        System.out.println("Linked List is - ");
        fl.printLLInLoop(head);
        System.out.println("Loop found at: " + fl.findLoopStartPoint(head));
    }
}