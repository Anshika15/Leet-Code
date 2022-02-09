class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        String res = "";
        int i = -1;
        int j = -1;
        int matchCount = 0;
        int desiredCount = t.length();
        
        for(char ch : t.toCharArray())
        {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        
        while(true)
        {
            boolean flag1 = false;
            boolean flag2 = false;
            
            while(i < s.length() - 1 && matchCount < desiredCount)
            {
                i++;
                char ch = s.charAt(i);
                
                map1.put(ch, map1.getOrDefault(ch, 0)+1);
                
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0))
                {
                    matchCount++;
                }
                flag1 = true;
            }
            
            while(j < i && matchCount == desiredCount)
            {
                j++;
                String pans = s.substring(j, i+1);
                if(res.length() == 0 || res.length() > pans.length())
                {
                    res = pans;
                }
                
                char ch = s.charAt(j);
                
                if(map1.get(ch) == 1)
                    map1.remove(ch);
                else
                {
                    map1.put(ch, map1.get(ch) - 1);
                }
                
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0))
                    matchCount--;
                flag2 = true;
            }
            
            if(flag1 == false && flag2 == false)
                break;
        }
        
        return res;
        
    }
}
