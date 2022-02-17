class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            g.add(new ArrayList<>());
        }
        
        for(int i = 0; i < dislikes.length; i++)
        {
            int src = dislikes[i][0] - 1;
            int dest = dislikes[i][1] - 1;
            
            g.get(src).add(dest);
            g.get(dest).add(src);
        }
        
        int[] vis = new int[n];
        
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < n; i++)
        {
            if(vis[i] == -1)
            {
                boolean isBipartite = bfs(vis, i, g);
                if(!isBipartite)
                    return false;
            }
        }
        return true;
        
    }
    
    boolean bfs(int[] vis, int src, ArrayList<ArrayList<Integer>> g)
    {
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        
        while(q.size() > 0)
        {
            Pair rem = q.removeFirst();
            if(vis[rem.src] != -1)
            {
                if(vis[rem.src] != rem.level)
                    return false;
            }
            else
            {
                vis[rem.src] = rem.level;
            }
            
            for(int nbr : g.get(rem.src))
            {
                if(vis[nbr] == -1)
                {
                    q.add(new Pair(nbr, rem.level+1));
                }
            }
        }
        return true;
    }
    
    class Pair{
        int src;
        int level;
        Pair(){}
        
        Pair(int src, int level)
        {
            this.src = src;
            this.level = level;
        }
    }
}
