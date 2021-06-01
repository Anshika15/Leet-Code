class Solution {
    
    int r;
    int c;
    int ans = Integer.MIN_VALUE;
    public int maxAreaOfIsland(int[][] grid) {
        
        
        r = grid.length;
        c = grid[0].length;
       
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1)
                {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        
        if(ans == Integer.MIN_VALUE)
            return 0;
        
        return ans;
    }
    
    public int dfs(int[][] grid, int i, int j)
    {
        if(i >= 0 && j < c && i < r && j >= 0 && grid[i][j] == 1)
        {
            grid[i][j] = 0;
            return (1 + dfs(grid, i-1, j) + dfs(grid, i, j-1) + dfs(grid, i+1, j) + dfs(grid, i, j+1));
        }
        
        return 0;
    }
}
