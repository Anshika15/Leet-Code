class Solution {
    public String longestPalindrome(String str) {
        
        int idx1 = 0;
        int idx2 = 0;
        boolean dp[][] = new boolean[str.length()][str.length()];
        for(int g = 0; g < dp.length; g++)
        {
            for(int i = 0, j = g; j < dp.length; j++, i++)
            {
                if(g == 0)
                {
                    dp[i][j] = true;
                }
                else if(g == 1)
                {
                    if(str.charAt(i) == str.charAt(j))
                    {
                        dp[i][j] = true;
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
                        if(dp[i+1][j-1] == true){
                            dp[i][j] = true;
                        }
                    }
                }
                
                if(dp[i][j] == true)
                {
                    idx1 = i;
                    idx2 = j;
                }
            }
            
            
        }
        
        return str.substring(idx1, idx2+1);
    }
}
