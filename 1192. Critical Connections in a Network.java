class Solution {
    
    int low[] ;
    int disc[] ;
    int parent[];
    boolean vis[];
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i < connections.size(); i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            g.get(u).add(v);
            g.get(v).add(u);
        }
        
        low = new int[n];
        disc = new int[n];
        parent = new int[n];
        time = 0;
        vis = new boolean[n];
        
        bridges(0, g, res);
        return res;
    }
    
    public void bridges(int src, List<List<Integer>> g, List<List<Integer>> res )
    {
        disc[src] = low[src] = time;
        time++;
        vis[src] = true;
        
        for(int i = 0; i < g.get(src).size(); i++)
        {
            int nbr = g.get(src).get(i);
            
            if(parent[src] == nbr)
            {
                continue;
            }
            else if(vis[nbr] == true)
            {
                low[src] = Math.min(low[src], disc[nbr]);
            }
            else
            {
                parent[nbr] = src;
                bridges(nbr, g, res);
                low[src] = Math.min(low[src], low[nbr]);
                if(low[nbr] > disc[src])
                {
                    LinkedList<Integer> temp = new LinkedList<>();
                    temp.add(src);
                    temp.add(nbr);
                    res.add(temp);
                }
            }
        }
        
    }
}
