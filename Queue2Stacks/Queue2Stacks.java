import java.util.Stack;

public class Queue2Stacks<T> {
    Stack<T> stackNewest;
    Stack<T> stackOldest;

    public Queue2Stacks() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public void enqueue(T value) {
        stackNewest.push(value);
    }

    public void shiftStacks() {
        if(stackOldest.isEmpty()) {
            while(!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T dequeue(){
        shiftStacks();
        return stackOldest.pop();
    }

    public static void main(String[] args) {
        Queue2Stacks<Integer> q2s = new Queue2Stacks<Integer>();
        q2s.enqueue(5);
        System.out.println(q2s.dequeue());
        q2s.enqueue(6);
        q2s.enqueue(7);
        System.out.println(q2s.dequeue());
        q2s.enqueue(8);
        System.out.println(q2s.dequeue());
        q2s.enqueue(9);
        System.out.println(q2s.dequeue());
    }
}