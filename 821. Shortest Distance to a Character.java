class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int prev = Integer.MAX_VALUE;
        int[] res = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == c)
                prev = i;
            
            if(prev != Integer.MAX_VALUE)
                res[i] = i - prev;
            else
                res[i] = Integer.MAX_VALUE;
        }
        
        
        prev = Integer.MAX_VALUE;
        
        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(s.charAt(i) == c)
                prev = i;
            
           res[i] = Math.min(res[i], prev - i);
        }
        
        
        return res;
        
    }
}
