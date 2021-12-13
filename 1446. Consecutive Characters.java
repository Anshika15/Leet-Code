class Solution {
    public int maxPower(String s) {
        
        int ans = 1;
        
        int c = 1;
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) == s.charAt(i-1))
            {
                c++;
                ans = Math.max(ans, c);
            }
            else
                c = 1;
        }
        return ans;
        
    }
}
