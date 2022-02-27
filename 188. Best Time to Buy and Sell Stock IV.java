class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0)
            return 0;
        
        int[][] dp = new int[k+1][prices.length];
        
        
        for(int i = 1; i <= k; i++)
        {
            for(int j = 1; j < prices.length; j++)
            {
                int max = dp[i][j-1];
                for(int l = 0; l < j; l++)
                {
                    max = Math.max(max, dp[i-1][l] + prices[j] - prices[l]);
               }
               dp[i][j] = max;
            }
        }
        
        return dp[k][prices.length-1];
        
    }
}
