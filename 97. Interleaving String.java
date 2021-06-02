class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        
        if(m + n - 2 != s3.length())
            return false;
            
        boolean dp[][] = new boolean[m][n];
        
        for(int i = 0; i < m; i++) // till s1 length
        {
            for(int j = 0; j < n; j++) // till s2 length
            {
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                
                else if(i == 0) 
                {
                    if(s2.charAt(j-1) == s3.charAt(j-1))
                        dp[i][j] = dp[i][j-1];
                }
                
                else if(j == 0) 
                {
                    if(s1.charAt(i-1) == s3.charAt(i-1))
                        dp[i][j] = dp[i-1][j];
                }
                
                else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) != s3.charAt(i+j-1))
                {
                    dp[i][j] = dp[i-1][j];
                }
                
                else if(s1.charAt(i-1) != s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1))
                {
                    dp[i][j] = dp[i][j-1];
                }
                
                else if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1))
                {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
