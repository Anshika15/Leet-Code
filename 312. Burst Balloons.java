class Solution {
    public int maxCoins(int[] nums) {
        
        int dp[][] = new int[nums.length][nums.length];
        
        for(int g = 0; g < nums.length; g++)
        {
            for(int i = 0, j = g; j < nums.length; i++, j++)
            {
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++)
                {
                    int left = k == i ? 0 : dp[i][k-1];
                    int right = k == j ? 0 : dp[k+1][j];
                    
                    int val = nums[k];
                    if(i > 0)
                        val = val*nums[i-1];
                    if(j < nums.length-1)
                        val = val*nums[j+1];
                    int total = left+right+val;
                    max = Math.max(max, total);
                }
                dp[i][j] = max;
            }
        }
        
        return dp[0][dp.length-1];
    }
}
