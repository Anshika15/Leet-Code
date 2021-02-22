class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int mx = Integer.MIN_VALUE;
        int j = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(j < s.length())
        {
            if(!map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j), 1);
            }
            else 
            {
                int c = map.get(s.charAt(j));
                c += 1;
                map.replace(s.charAt(j), c);
            }
          // System.out.println(map);
            
            if(map.size() == j-i+1)
            {
                 mx = Math.max(mx, j-i+1);
               // System.out.println(mx);
            }
               
            else if(map.size() < j-i+1)
            {
                while(map.size() < j-i+1)
                {
                   // System.out.println("i :" + i + "j : " + j);
                     if(map.containsKey(s.charAt(i)))
                    {
                         int c = map.get(s.charAt(i));
                         c -= 1;
                         map.replace(s.charAt(i), c);
                        if(c == 0)
                        {
                            map.remove(s.charAt(i));
                        }
                    }
                    i++;
                }  
            }
            j++;
        }
        if(mx == Integer.MIN_VALUE)
            return 0;
        return mx;
        
    }
}
