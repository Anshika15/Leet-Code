class Solution {
    
    int[] parent;
    int rank[];
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        int count = 0;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isConnected[i][j] == 1 && i != j)
                {
                    if(union(i, j))
                        count++;
                }
            }
        }
        return n - count;
        
    }
    
    public boolean union(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly)
        {
            if(rank[lx] > rank[ly])
            {
                parent[ly] = lx;
            }
            else if(rank[lx] < rank[ly])
            {
                parent[lx] = ly;
            }
            else
            {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }
    
    public int find(int x)
    {
        if(x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
