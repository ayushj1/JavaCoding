import java.util.*;

public class DFSGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    public DFSGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
    }

    public void DFSUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.println("" + start + " ");

        Iterator<Integer> i = adj[start].listIterator();
        while(i.hasNext()) {
            int next = i.next();
            if(!visited[next]) {
                DFSUtil(next, visited);
            }
        }
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal (starting from vertex 2)"); 
  
        g.DFS(2);
    }
}