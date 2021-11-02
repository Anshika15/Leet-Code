class Solution {
    int res = 0;
    int count = 1;
    public int uniquePathsIII(int[][] grid) {
        
       int x = -1; int y = -1;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    x = i;
                    y = j;
                }        
                else if(grid[i][j] == 0)
                    count++;
            }
        }

        dfs(x, y, grid);
        return res;
        
    }
    
    void dfs(int i, int j, int[][] grid)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0)
            return;
        
        if(grid[i][j] == 2)
        {
            if(count == 0)
                res++;
          //  System.out.println(res);
            return;
        }
        
        
        grid[i][j] = -1;
        count--;
        
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        
        grid[i][j] = 0;
        count++;
    }
    
    class Pair{
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
}
