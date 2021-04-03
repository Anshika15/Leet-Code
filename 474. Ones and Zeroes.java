class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int t[][] = new int[m+1][n+1];
        
        for(String str: strs)
        {
            int zeroes = 0, ones = 0;
            for(char c : str.toCharArray())
            {
                if(c == '0')
                    zeroes++;
                else
                    ones++;
            }
            
            for(int i = m; i >= zeroes; i--)
            {
                for(int j = n; j >= ones; j--)
                {
                    t[i][j] = Math.max(t[i][j], t[i-zeroes][j-ones] + 1);
                    //System.out.println(i +  " - " + j + " : " + t[i][j]);
                }
            }
        }
        
        return t[m][n];
    }
}
