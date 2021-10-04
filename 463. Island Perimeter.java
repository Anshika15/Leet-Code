class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int c = 0;
        int n = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    c++;
                    if(i < grid.length-1 && grid[i+1][j] == 1) n++;
                    if(j < grid[i].length-1 && grid[i][j+1] == 1) n++;
                }
            }
        }
        return c*4 - n*2;
    }
}
