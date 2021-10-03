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
    
    public int orangesRotting(int[][] grid) {
        
        LinkedList<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
        
        if(fresh == 0)
            return 0;
        
        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        int level = -1;
        while(q.size() > 0)
        {
            level++;
            int size = q.size();
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                for(int i = 0; i < 4; i++)
                {
                    int rowdash = rem.i + dirs[i][0];
                    int coldash = rem.j + dirs[i][1];
                    
                    if(rowdash >= 0 && coldash >= 0 && rowdash < grid.length && coldash < grid[0].length && grid[rowdash][coldash] == 1)
                    {
                        q.add(new Pair(rowdash,coldash));
                        grid[rowdash][coldash] = 0;
                        fresh--;
                    }
                }
              
            }
        }
        
        if(fresh == 0)
            return level;
        return -1;
        
    }
}
