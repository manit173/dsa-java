package AdvancedTopics;

public class FordFulkerDFS {
    private int V;

    public FordFulkerDFS(int V){
        this.V = V;
    }

    //dfs searches for any augmenting path from source to sink
    private boolean dfs(int[][] residualGraph, int u, int sink, boolean[] visited, int [] parent){
        visited[u] = true;
         if(u == sink)return true;

         for(int v =0;v<V;v++){
             //edge ca be used only if residual capacity>0
             if(!visited[v] && residualGraph[u][v]>0){
                 parent[v]=u;
                 if(dfs(residualGraph, v, sink, visited, parent))
                     return true;
             }
         }return false;
    }
    public int maxFlow(int[][] graph, int source, int sink){
        //initially residual capacity = original capacity
        int [][] residualGraph = new int[V][V];

        for(int u =0;u<V;u++){
            for(int v =0;v<V;v++){
                residualGraph[u][v] = graph[u][v];
            }
        }
        int[] parent = new int[V];

    }
}
