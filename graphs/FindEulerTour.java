// AUTHOR: Soel Micheletti

import java.util.ArrayList;


class W{
    ArrayList<Integer> W = new ArrayList<Integer>();
}

class Node{
    int dest; 
    int weight; 
    boolean acc; 

    public Node(int dest, int weight){
        this.dest = dest; 
        this.weight = weight; 
        acc = true; 
    }
}

class Graph{
    int V; 
    ArrayList<ArrayList<Node>> L = new ArrayList<ArrayList<Node>>(); 
  
    public Graph(int V){
        this.V = V; 
        for(int i = 0; i<V; i++)
        	L.add(new ArrayList<Node>()); 
    }

    public void edge(int src, int dest, int weight){
        L.get(src).add(new Node(dest, weight)); 
    }

    public void delete(int src, int dest, int weight){
        for (int i = 0; i < L.get(src).size(); i++) {
            if(L.get(src).get(i).dest == dest)
                L.get(src).get(i).acc = false; 
        }
    }

}

public class Euler{
    
    public static void EulerTour(Graph G, int v){
        W w = RandomTour(G, v); 
        int v_slow = w.W.get(0); 
        while(v_slow != w.W.get(w.W.size()-2)){
            int t = 0; 
            for(int i = 0; i<w.W.size()-1; i++){
                if(w.W.get(i) == v_slow)
                    t = w.W.get(i+1); 
            }
            W w1 = new W(); 
            ArrayList<Integer> prov = new ArrayList<Integer>(); 
            if(acc(G, t)){
                 w1 = RandomTour(G, t); 
                 for(int i = 0; i<t; i++){
                     prov.add(w.W.get(i));
                 }
                 for(int i = 0; i<w1.W.size(); i++)
                     prov.add(w1.W.get(i)); 
                 for(int i = t+1; i<w.W.size(); i++)
                     prov.add(w.W.get(i));
                 w.W = prov;   
            }
            
            v_slow = t; 
        }

        for(int i = 0; i<w.W.size(); i++)
        	System.out.print(w.W.get(i) + "  ");
    }
    
    public static boolean acc(Graph G, int v) {
    	for(int i = 0; i<G.L.get(v).size(); i++) {
    		if(G.L.get(v).get(i).acc == true)
    			return true; 
    	}
    	return false; 
    }
    
    public static W RandomTour(Graph G, int v){
        W w = new W();
        w.W.add(v); 
        while(acc(G, v)){
        	int p = 0; 
            while(G.L.get(v).get(p).acc == false) {
            	p++; 
            }
            int v1 = G.L.get(v).get(p).dest; 
            w.W.add(v1); 
            G.delete(v, v1, G.L.get(v).get(p).weight);
            v = v1; 
        }
        return w; 
    }

    public static void main(String[] args) {
        Graph G = new Graph(6); 
        G.edge(0, 1, 1); 
        G.edge(1, 2, 1); 
        G.edge(2, 3, 1);
        G.edge(3, 4, 1);
        G.edge(4, 5, 1);
        G.edge(5, 0, 1);
        G.edge(1, 4, 1);
        G.edge(4, 2, 1);
        G.edge(2, 5, 1);
        G.edge(5, 1, 1);

        EulerTour(G, 0); 
    }
}
