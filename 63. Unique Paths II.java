class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int t[][] = new int[m][n];
        
        for(int i = 0; i < n; i++)
        {
            if(obstacleGrid[0][i] == 1)
            {
                t[0][i] = 0;
                break;
            }
            else t[0][i] = 1;
        }
        
        for(int i = 0; i < m; i++)
        {
            if(obstacleGrid[i][0] == 1)
            {
                t[i][0] = 0;
                break;
            }
            else t[i][0] = 1;
        }
        
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(obstacleGrid[i][j] == 1)
                    t[i][j] = 0;
                else
                    t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}
