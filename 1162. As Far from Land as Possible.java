class Solution {
    
    class Pair{
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    public int maxDistance(int[][] grid) {
        
        LinkedList<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    q.add(new Pair(i, j));
            }
        }
        
        if(q.size() == 0 || q.size() == grid.length*grid[0].length)
            return -1;
        
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int level = -1;
        while(q.size() > 0)
        {
            int size = q.size();
            level++;
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                
                for(int i = 0; i < 4; i++)
                {
                    int rowdash = dirs[i][0] + rem.i;
                    int coldash = dirs[i][1] + rem.j;
                    
                    if(rowdash >= 0 && rowdash < grid.length && coldash >= 0 && coldash < grid[0].length && grid[rowdash][coldash] == 0 )
                    {
                        q.add(new Pair(rowdash, coldash));
                        grid[rowdash][coldash] = 1;
                    }
                }
                
            }
        }
        
        return level;
        
    }
}
