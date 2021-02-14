class Solution {
    int V;
    int color[];
    public boolean isBipartite(int[][] graph) {
        
        V = graph.length;
        color = new int[V];
        Arrays.fill(color, -1);
        for(int i = 0; i < V; i++)
        {
            if(color[i] == -1)
                if(!bipartite(graph, i))
                    return false;
        }
        return true;
  
    }
    
    boolean bipartite(int[][] graph, int u)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.add(u);
        color[u] = 1;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int i = 0; i < graph[curr].length; i++)
            {
                int ele = graph[curr][i];
                if(color[ele] == color[curr])
                    return false;
                if(color[ele] == -1)
                {
                    color[ele] = 1-color[curr];
                    q.add(ele);
                }
            }
        }
        return true;
    }
    
    
}
