class Solution {
    public int countPalindromicSubsequences(String str) {
        
        int[][] dp = new int[str.length()][str.length()];
		
		int[] prev = new int[str.length()];
		HashMap<Character, Integer> map = new HashMap<>(); // to store the index of char
		
		for(int i = 0; i < str.length(); i++)
		{
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false)
		    {
		        prev[i] = -1;
		    }
		    else
		    {
		        prev[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		int[] next = new int[str.length()];
		map.clear();
		for(int i = str.length()-1; i >= 0; i--)
		{
		    char ch = str.charAt(i);
		    
		    if(map.containsKey(ch) == false)
		    {
		        next[i] = -1;
		    }
		    else
		    {
		        next[i] = map.get(ch);
		    }
		    map.put(ch, i);
		}
		
		for(int g = 0; g < str.length(); g++)
		{
		    for(int i = 0, j = g; j < str.length(); i++, j++)
		    {
		        if(g == 0)
		        {
		            dp[i][j] = 1;
		        }
		        else if(g == 1)
		        {
		            dp[i][j] = 2;
		        }
		        else
		        {
		            char startChar = str.charAt(i);
		            char endChar = str.charAt(j);
		            
		            if(startChar != endChar)
		            {
		                dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; // prefix + suffix - middle
		            }
		            else
		            {
		                int nextIdx = next[i]; // get next idx of start char
		                int prevIdx = prev[j]; // get prev index of end char
		                
		                if(nextIdx > prevIdx)
		                {
		                    // case 1
		                    dp[i][j] = (2* dp[i+1][j-1]) + 2;
		                }
		                else if(nextIdx == prevIdx)
		                {
		                    // case 2
		                    dp[i][j] = (2*dp[i+1][j-1]) + 1;
		                }
		                else
		                {
		                    // case 3
		                    dp[i][j] = (2*dp[i+1][j-1]) - dp[nextIdx + 1][prevIdx - 1];
		                }
		            }
		        }
                
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
		    }
		}
		
		
		return dp[0][str.length()-1];
        
    }
}
