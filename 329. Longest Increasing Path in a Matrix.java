class Solution {
    
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        
        int m = matrix.length; int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int result = 0;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int len = dfs(i, j, matrix, dp, m, n);
                result = Math.max(result, len);
            }
        }
        return result;
    }
    
    int dfs(int i, int j, int[][] matrix, int[][] dp, int m, int n)
    {
        if(dp[i][j] != 0)
            return dp[i][j];
        
        int max = 1;
        
        for(int idx = 0; idx < 4; idx++)
        {
            int rowdash = dirs[idx][0] + i;
            int coldash = dirs[idx][1] + j;
            if(rowdash < 0 || coldash < 0 || rowdash >= m || coldash >= n || matrix[i][j] >= matrix[rowdash][coldash])
                continue;
            max = Math.max(max, 1 + dfs(rowdash, coldash, matrix, dp, m, n));
        }
        
        dp[i][j] = max;
        return max;
        
    }
}
