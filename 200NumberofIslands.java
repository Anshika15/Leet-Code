class Solution {
    public void mark(char[][] grid, int i, int j, int r, int c)
    {
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != '1')
            return;
        grid[i][j] = 2;
        mark(grid, i, j+1, r, c);
        mark(grid, i+1, j, r, c);
        mark(grid, i-1, j, r, c);
        mark(grid, i, j-1, r, c);
    }
    
    
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0 ; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    mark(grid, i, j, grid.length, grid[0].length);
                    num++;
                }
            }
        }
        return num;
    }
}
