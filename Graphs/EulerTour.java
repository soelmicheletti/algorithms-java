// AUTHOR: Soel Micheletti
import java.util.ArrayList; 
import java.util.Stack; 

class Node{
    int dest; 
    int weight; 

    public Node(int dest, int weight){
        this.dest = dest; 
        this.weight = weight; 
    }
}


class Graph{
    int V; 
    ArrayList<ArrayList<Node>> L = new ArrayList<ArrayList<Node>>(); 

    public Graph(int V){
        this.V = V; 
       for (int i = 0; i < V; i++) {
          L.add(new ArrayList<Node>());  
       }    
    }
    
    public void edge(int src, int dest, int weight){
        L.get(src).add(new Node(dest, weight));
    }
}

class IndirectedGraph{
    int V; 
    ArrayList<ArrayList<Node>> L = new ArrayList<ArrayList<Node>>(); 

    public IndirectedGraph(int V){
        this.V = V; 
       for (int i = 0; i < V; i++) {
          L.add(new ArrayList<Node>());  
       }    
    }
    
    public void edge(int src, int dest, int weight){
        L.get(src).add(new Node(dest, weight));
        L.get(dest).add(new Node(dest, weight));
    }
}



public class EulerTour{
    
    public static int DFS(IndirectedGraph G){
        boolean[] vis = new boolean[G.V]; 
        Stack<Integer> S = new Stack<Integer>(); 
        S.add(0);
        int num = 0;
        while(!S.isEmpty()){
            int w = S.pop(); 
            num++; 
            vis[w] = true; 
            for(int i = 0; i<G.L.get(w).size(); i++){
                if(!vis[G.L.get(w).get(i).dest])
                    S.add(G.L.get(w).get(i).dest);
            }
        }
        return num; 
    }
    
    public static String eulerTour(Graph G){
        int[] in = new int[G.V]; 
        int[] out = new int[G.V]; 
        IndirectedGraph g = new IndirectedGraph(G.V); 
        for (int i = 0; i < G.V; i++) {
            for(int j = 0; j < G.L.get(i).size(); j++){
                g.edge(i, G.L.get(i).get(j).dest, G.L.get(i).get(j).weight);
            }
        }

        if(DFS(g) != g.V){
            return "no"; 
        }

        for(int i = 0; i<G.V; i++){
            for(int j = 0; j<G.L.get(i).size(); j++){
                in[G.L.get(i).get(j).dest]++; 
                out[i]++; 
            }
        }
        int a = 0; 
        int b = 0; 
        for (int i = 0; i < G.V; i++) {
            if(out[i] == in[i]+1)
                a++;
            else if(out[i]+1 == in[i])
                b++; 
        }

        if(a>1 || b>1)
            return "no"; 
        return "yes"; 
    }
    
    public static void main(String[] args) {
        
       Graph G = new Graph(5); 
       G.edge(1, 0, 1);
       G.edge(0, 3, 1);
       G.edge(3, 4, 1); 
       G.edge(4, 0, 1);
       G.edge(0, 2, 1);
       G.edge(2, 1, 1);
    
       System.out.println(eulerTour(G));
    }
}
