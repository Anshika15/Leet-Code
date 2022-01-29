class Solution {
    
    int[] parent;
    int rank[];
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        
        int[] indegree = new int[n+1];
        Arrays.fill(indegree, -1);
        
        int bl1 = -1; // blacklist1
        int bl2 = -1; // blacklist2
        
        for(int i = 0; i < n; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(indegree[v] == -1)
                indegree[v] = i;
            else{
                bl1 = i;
                bl2 = indegree[v];
            }
        }
        
        for(int i = 0; i <= n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(i == bl1)
                continue;
            
            int u = edges[i][0];
            int v = edges[i][1];

            boolean cycle = union(u,v);
            if(cycle)
            {
                if(bl1 == -1)
                   return edges[i]; // if only cycle exists
                else
                   return edges[bl2]; // if cycle and 2 parents exist ans is the one which is present in cycle
            }
        }
        return edges[bl1];
    }
    
    public boolean union(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly) // no cycle
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
            return false;
        }
        else
        {
            // cycle
            return true;
        }
    }
    
    public int find(int x)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
