class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] != 0)
                    dfs(grid, i, j, vis, 0, n, m);
            }
        }
        
        return max;
    }
    
    void dfs(int[][] grid, int i, int j, boolean vis[][], int sum, int n, int m)
    {
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == true || grid[i][j] == 0)
            return;
        
       // max = Math.max(max, sum);
        sum += grid[i][j];
        vis[i][j] = true;
        
        dfs(grid, i+1, j, vis, sum, n, m);
        dfs(grid, i-1, j, vis, sum, n, m);
        dfs(grid, i, j+1, vis, sum, n, m);
        dfs(grid, i, j-1, vis, sum, n, m);
        
        max = Math.max(max, sum);
        
        sum -= grid[i][j];
        vis[i][j] = false;
    }
}
