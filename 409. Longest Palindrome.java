class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        int res = 0;
        boolean odd = false;
        for(char ch : map.keySet())
        {
            if(map.get(ch)%2 == 0)
            {
                res += map.get(ch);
            }
            else
            {
                res += map.get(ch) - 1;
                odd = true;
            }
        }
        if(odd == true)
            return res+1;
        return res;
        
    }
}
