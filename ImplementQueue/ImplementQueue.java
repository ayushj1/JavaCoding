class Node {
    Object data;
    Node next = null;

    public Node(Object data) {
        this.data = data;
    }
}

public class ImplementQueue {
    Node first, last;
    
    public void enqueue(Object item) {
        if(first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }

    }

    public Object dequeue() {
        if(first != null) {
            Object item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }

    public static void main(String[] args) {
        ImplementQueue imqu = new ImplementQueue();
        imqu.enqueue("Ayush");
        imqu.enqueue("Shubha");
        imqu.enqueue(1);
        imqu.enqueue("Aarju");
        imqu.enqueue(4);
        System.out.println(imqu.dequeue());
        System.out.println(imqu.dequeue());
        System.out.println(imqu.dequeue());
        System.out.println(imqu.dequeue());
        System.out.println(imqu.dequeue());
    }
}