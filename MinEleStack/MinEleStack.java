import java.util.Stack;
public class MinEleStack extends Stack<Integer>{
    Stack<Integer> s2;

    public MinEleStack() {
        s2 = new Stack<Integer>();
    }

    public void push(int value) {
        if(value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if(s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
    public static void main(String[] args) {
        MinEleStack mes = new MinEleStack();
        System.out.println("Min is: " + mes.min());
        mes.push(5);
        System.out.println("Min is: " + mes.min());
        mes.push(6);
        System.out.println("Min is: " + mes.min());
        mes.push(3);
        System.out.println("Min is: " + mes.min());
        mes.push(7);
        System.out.println("Min is: " + mes.min());
        mes.pop();
        System.out.println("Min is: " + mes.min());
        mes.pop();
        System.out.println("Min is: " + mes.min());
    }
}