class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class AddNumbersLL {
    public void printLL(Node node) {
        System.out.println();
        while(node.next != null) {
            System.out.print("" + node.data);
            System.out.print("->");
            node = node.next;
        }
        System.out.print("" + node.data);
    }

    public Node reverseLinkedList (Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public Node addTwoLLHelper (Node ll1, Node ll2, int carry) {
        if(ll1 == null && ll2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if(ll1 != null) {
            value += ll1.data;
        }
        if(ll2 != null) {
            value += ll2.data;
        }

        Node result = new Node(value%10);

        if(ll1 != null || ll2 != null) {
            Node more = addTwoLLHelper(ll1 == null ? null : ll1.next, ll2 == null ? null : ll2.next, value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    public Node addTwoLL (Node ll1, Node ll2) {
        ll1 = reverseLinkedList(ll1);
        ll2 = reverseLinkedList(ll2);

        Node result = addTwoLLHelper(ll1, ll2, 0);
        
        result = reverseLinkedList(result);

        return result;
    }

    public static void main(String[] args) {
        Node ll1 = new Node(1);
        ll1.next = new Node(2);
        ll1.next.next = new Node(3);

        Node ll2 = new Node(8);
        ll2.next = new Node(7);
        ll2.next.next = new Node(7);

        AddNumbersLL adnll = new AddNumbersLL();
        
        System.out.println("First Linked List is - ");
        adnll.printLL(ll1);
        System.out.println();

        System.out.println("Second Linked List is - ");
        adnll.printLL(ll2);
        System.out.println();

        Node result = adnll.addTwoLL(ll1, ll2);
        System.out.println("Summed up Linked List is - ");
        adnll.printLL(result);
    }
}