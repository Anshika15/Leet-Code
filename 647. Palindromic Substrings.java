class Solution {
    public int countSubstrings(String str) {
        
        boolean[][] dp = new boolean[str.length()][str.length()];
        int c = 0;
        for(int g = 0; g < dp.length; g++)
        {
            for(int i = 0, j = g; j < dp.length; j++, i++)
            {
                if(g == 0)
                {
                    dp[i][j] = true;
                    c++;
                }
                else if(g == 1)
                {
                    if(str.charAt(i) == str.charAt(j))
                    {
                        dp[i][j] = true;
                        c++;
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    if(str.charAt(i) != str.charAt(j))
                    {
                        dp[i][j] = false;
                    }
                    else
                    {
                        /* check whether middle is palindrome or not*/
                        dp[i][j] = dp[i+1][j-1];
                        if(dp[i][j] == true)
                        c++;
                    }
                }
            }
        }
        return c;
        
    }
}
