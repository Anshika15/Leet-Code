class Solution {
    public int minDistance(String word1, String word2) {
        
        if(word1.equals(word2))
            return 0;
        
        int val = lcs(word1, word2, word1.length(), word2.length());
        return word1.length() + word2.length() - 2*val;
    }
    
    public int lcs(String x, String y, int m, int n)
    {
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++)
        {
            for(int j = 0; j < n+1; j++)
            {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        
        for(int i = 1; i < m+1; i++)
        {
            for(int j = 1; j < n+1; j++)
            {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        
        return t[m][n];
    }
}
