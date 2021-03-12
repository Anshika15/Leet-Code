class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int m = coins.length + 1;
        int n = amount + 1;
        int t[][] = new int[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == 0)
                    t[i][j] = 0;
                if(i == 0)
                    t[i][j] = Integer.MAX_VALUE;        
            }
        }
        
        for(int i = 1; i < n ; i++)
        {
            if(i % coins[0] == 0)
                t[1][i] = i/coins[0];
            else
                t[1][i] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 2; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(coins[i-1] <= j)
                {
                    t[i][j] = Math.min(t[i][j-coins[i-1]] + 1, t[i-1][j]);
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        if(t[m-1][n-1] >= Integer.MAX_VALUE - 1)
            return -1;
        return t[m-1][n-1];
    }
}
