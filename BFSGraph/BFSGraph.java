import java.util.*;

public class BFSGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    public BFSGraph (int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0) {
            start = queue.poll();
            System.out.println("" + start + " ");

            Iterator<Integer> i = adj[start].listIterator();
            while(i.hasNext()) {
                int next = i.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1); 
        g.addEdge(0, 2);
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)"); 
  
        g.BFS(2); 
    }
}