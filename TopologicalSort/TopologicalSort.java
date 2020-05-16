import java.util.*;

public class TopologicalSort {
    private int V;
    private LinkedList<Integer>[] adj;

    public TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int start, int end) {
        adj[start].add(end);
    }

    public void topologicalSortUtil(int cur, boolean[] visited, Stack<Integer> stack) {
        visited[cur] = true;

        Iterator<Integer> i = adj[cur].listIterator();
        while(i.hasNext()) {
            int next = i.next();
            if(!visited[next])
                topologicalSortUtil(next, visited, stack);
        }

        stack.push(cur);
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("" + stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);

        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(5,0);
        g.addEdge(5,1);

        System.out.println("Topological Sort is : ");
        g.topologicalSort();
    }
}