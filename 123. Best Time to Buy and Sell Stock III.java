class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        /*
        The difference between these two methods is that in the first method the profit is based on buying at the lowest price and in the second method the profit is based on selling at the highest price.
        */
        
        /* first-> max profit if we sell upto today */
        
        int min = prices[0];
        int dp[] = new int[prices.length];
        int proftIfSoldToday = 0;
        for(int i = 1; i < prices.length; i++)
        {
            min = Math.min(min, prices[i]); 
            proftIfSoldToday = prices[i] - min;
            dp[i] = Math.max(proftIfSoldToday, dp[i-1]);
        }
        
        /* second-> max profit if we buy after today*/
        
        int max = prices[prices.length-1];
        int dp1[] = new int[prices.length];
        int proftIfBuyToday = 0;
        for(int i = prices.length-2; i >= 0; i--)
        {
            max = Math.max(max, prices[i]); 
            proftIfBuyToday = max - prices[i]; 
            dp1[i] = Math.max(proftIfBuyToday, dp1[i+1]);
        }
        
        int res = 0;
        for(int i = 0; i < prices.length; i++)
        {
            res = Math.max(res, dp[i]+dp1[i]);
        }
        return res;
    }
}
