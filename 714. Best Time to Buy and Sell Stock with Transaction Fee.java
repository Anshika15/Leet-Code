class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        if(prices.length <= 1)
            return 0;
        int days = prices.length;
        int buy[] = new int[days], sell[] = new int[days];
        
        buy[0] = -prices[0]; // at first day if we buy stock
        sell[0] = 0; // at first day we can't sell the stock
        for(int i = 1; i < days; i++)
        {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
            //System.out.println(buy[i] + " " + sell[i]);
        }
        return sell[days-1];
    }
}
