public class Array3Stacks {
    int[] arr;
    int[] top;
    int[] next;
    int n,k,free;
    
    public Array3Stacks(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        for(int i=0; i<k; i++) {
            top[i] = -1;
        }

        free = 0;

        for(int i=0; i<n-1; i++) {
            next[i] = i+1;
        }
        next[n-1] = -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public boolean isEmpty(int sn) {
        return top[sn] == -1;
    }

    public void push(int item, int sn) {
        if(isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int i = free;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;

        arr[i] = item;
    }

    public int pop(int sn) {
        if(isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }

        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;

        return arr[i];
    }
    
    public static void main(String[] args) {
        Array3Stacks ast = new Array3Stacks(10, 3);
        ast.push(15,2);
        ast.push(45,2);

        ast.push(17,1);
        ast.push(49,1);
        ast.push(39,1);
        ast.push(38,1);
        ast.push(37,1);
        ast.push(36,1);
        ast.push(35,1);

        ast.push(11,0);
        ast.push(9,0);
        ast.push(7,0);

        System.out.println("Popped element from stack 2 is " + ast.pop(2)); 
        System.out.println("Popped element from stack 1 is " + ast.pop(1)); 
        System.out.println("Popped element from stack 0 is " + ast.pop(0));
    }
}