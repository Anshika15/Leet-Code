class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int[][] dp = new int[dungeon.length+1][dungeon[0].length+1];
        
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        dp[dp.length-1][dp[0].length-2] = 1;
        dp[dp.length-2][dp[0].length-1] = 1;
        
        for(int i = dp.length-2; i >= 0; i--)
        {
            for(int j = dp[0].length-2; j >= 0; j--)
            {
               int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];

                if(need <= 0)
                    dp[i][j] = 1;
                else dp[i][j] = need;

            }
        }

        // for(int i = 0; i < dp.length; i++)
        // {
        //     for(int j = 0; j < dp[0].length; j++)
        //     {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // } 
        
        return dp[0][0];
        
    }
}
