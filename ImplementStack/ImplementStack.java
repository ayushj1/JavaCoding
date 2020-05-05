class Node {
    Object data;
    Node next = null;

    public Node(Object data) {
        this.data = data;
    }
}

public class ImplementStack {
    Node top;
    
    public Object pop() {
        if(top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    public void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    public Object peek() {
        return top.data;
    }

    public static void main(String[] args) {
        ImplementStack imst = new ImplementStack();
        imst.push("Ayush");
        imst.push("Shubha");
        imst.push(1);
        imst.push("Aarju");
        imst.push(4);
        System.out.println(imst.peek());
        System.out.println(imst.pop());
        System.out.println(imst.peek());
        System.out.println(imst.pop());
        System.out.println(imst.peek());
    }
}