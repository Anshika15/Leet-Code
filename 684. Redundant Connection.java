class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        for(int i = 0; i <= n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < edges.length; i++)
        {
            int lx = find(edges[i][0], parent);
            int ly = find(edges[i][1], parent);
            
            if(lx != ly)
            {
                if(rank[lx] > rank[ly])
                    parent[ly] = lx;
                else if(rank[lx] < rank[ly])
                    parent[lx] = ly;
                else
                {
                    parent[lx] = ly;
                    rank[ly]++;
                }
            }
            else
            {
                return edges[i];
            }
        }
        
        return new int[2];
        
    }
    
    int find(int x, int[] parent)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
