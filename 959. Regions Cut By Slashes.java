class Solution {
    int parent[];
    int rank[];
    int count;
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        int dots = n+1;
        
        parent = new int[dots*dots];
        rank = new int[dots*dots];
        count = 1;
        
        for(int i = 0; i < parent.length; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < dots; i++)
        {
            for(int j = 0; j < dots; j++)
            {
                if(i == 0 || j == 0 || i == dots-1 || j == dots - 1)
                {
                    int cellno = i*dots + j;
                    if(cellno != 0)
                    union(0, cellno);
                }
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            char ch[] = grid[i].toCharArray();
            for(int j = 0; j < ch.length; j++)
            {
                if(ch[j] == '/')
                {
                    int cellno1 = i*dots + j+1;
                    int cellno2 = (i+1)*dots + j;
                    union(cellno1, cellno2);
                }
                else if(ch[j] == '\\')
                {
                    int cellno1 = i*dots + j;
                    int cellno2 = (i+1)*dots + j+1;
                    union(cellno1, cellno2);
                }
            }
        }
        
        return count;
        
    }
    
    public int find(int x)
    {
        if(parent[x] == x)
            return parent[x];
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly)
        {
            if(rank[lx] > rank[ly])
                parent[ly] = lx;
            else if(rank[ly] > rank[lx])
                parent[lx] = ly;
            else
            {
               parent[lx] = ly;
                rank[ly]++;
            }
        }
        else
        {
            count++;
        }
    }
}
