class Solution {
    
    boolean vis[];
    public boolean validPath(int n, int[][] edges, int start, int end) {
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0;i < n; i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        vis = new boolean[n];
        return dfs(g, start, end);
        
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> g, int src, int dest)
    {
        if(src == dest)
            return true;
    
        if(!vis[src])
        {
            vis[src] = true;
            ArrayList<Integer> l = g.get(src);
            for(int ed : l)
            {
                if(!vis[ed]){
                    boolean hasPath = dfs(g, ed, dest);
                    if(hasPath == true)
                        return true;
                }
            }
        }
        return false;
    }
}
