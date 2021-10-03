class Solution {
    public int numEnclaves(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1)
                {
                    if(grid[i][j] == 1)
                    {
                        dfs(i, j, grid);
                    }
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    count++;
            }
        }
        
        return count;
        
    }
    
    public void dfs(int i, int j, int[][] grid)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}
