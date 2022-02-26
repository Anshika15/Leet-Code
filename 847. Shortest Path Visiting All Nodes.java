class Solution {
    public int shortestPathLength(int[][] graph) {
        
        if(graph.length == 1)
            return 0;
        int n = graph.length;
        
        int allN = (1 << n) - 1; // all nodes in 2^n-1 format
        
        LinkedList<Pair> q = new LinkedList<>(); // mask, node, dist
        
        boolean[][] vis = new boolean[n][allN];
        
        for(int i = 0; i < n; i++)
        {
            int mask = (1 << i); // 2^i
            q.addLast(new Pair(mask, i, 0));  
 
            vis[i][mask] = true;
        }
        
        while(q.size() > 0)
        {
            Pair rem = q.removeFirst();
            int nodeVal = rem.node;
            int dist = rem.dist;
            int mask = rem.mask;
            
            for(int nbr : graph[nodeVal])
            {
                int newMask = (mask | (1 << nbr));
                if(newMask == allN)
                {
                    return dist+1;
                }
                else if(vis[nbr][newMask])
                {
                    continue;
                }
                else
                {
                    vis[nbr][newMask] = true;
                    q.add(new Pair(newMask, nbr, dist+1));
                }
            }
        }
        return -1;
        
    }
    class Pair{
        int mask;
        int node;
        int dist;
        
        Pair(){}
        
        Pair(int mask, int node, int dist) // we will use this pair in q
        {
            this.mask = mask;
            this.node = node;
            this.dist = dist;
        }
    }
}
