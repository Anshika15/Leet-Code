class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for(int i = dp.length-1; i >= 0; i--)
        {
            for(int j = dp[0].length-1; j >= 0; j--)
            {
                if(i == dp.length-1 && j == dp[0].length-1)
                {
                    dp[i][j] = matrix[i][j] - '0';
                    res = Math.max(dp[i][j], res);
                }
                else if(i == dp.length-1)
                {
                    dp[i][j] = matrix[i][j] - '0';
                    res = Math.max(dp[i][j], res);
                }
                else if(j == dp[0].length-1)
                {
                    dp[i][j] = matrix[i][j] - '0';
                    res = Math.max(dp[i][j], res);
                }
                else
                {
                    if(matrix[i][j] == '0')
                    {
                        dp[i][j] = 0;
                    }
                    else
                    {
                        int min = Math.min(dp[i][j+1], dp[i+1][j]);
                        min = Math.min(dp[i+1][j+1], min);
                        dp[i][j] = min+1;
                        res = Math.max(dp[i][j], res);
                    }
                }
            }
        }
        
        return res*res;
        
    }
}
