class Solution {

    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1)
            return -1;
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            
            g.get(u).add(v);
            g.get(v).add(u);
        }
        
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i, temp, vis, g);
                comps.add(temp);
            }
        }
        
        return comps.size() - 1;
    }
    
    public static void dfs(int src, ArrayList<Integer> temp, boolean vis[], ArrayList<ArrayList<Integer>> g)
    {
        vis[src] = true;
        temp.add(src);
        ArrayList<Integer> nbr = g.get(src);
        for(int n : nbr)
        {
            if(!vis[n])
                dfs(n, temp, vis, g);
        }
    }
}
