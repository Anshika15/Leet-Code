class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length())
            return res;
        
        HashMap<Character, Integer> patternMap = new HashMap<>();
        
        for(char ch : p.toCharArray())
        {
            patternMap.put(ch, patternMap.getOrDefault(ch,0)+1);
        }
        
         HashMap<Character, Integer> strmap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++)
        {
            char ch = s.charAt(i);
            strmap.put(ch, strmap.getOrDefault(ch,0)+1);
        }
        
        int count = 0;
        int i = p.length();
        
        while(i < s.length())
        {
         //   System.out.println(i);
            if(strmap.equals(patternMap))
            {
                count++;
                res.add(i - p.length());
            }
            
            char ch = s.charAt(i);
            
            strmap.put(ch, strmap.getOrDefault(ch,0)+1);
            
            ch = s.charAt(i - p.length());
            if(strmap.get(ch) == 1)
            {
                strmap.remove(ch);
            }
            else
            {
                strmap.put(ch, strmap.get(ch)-1);
            }
            i++;
        }
        
        if(strmap.equals(patternMap))
        {
            count++;
            res.add(i - p.length());
        }
     
        return res;
    }
}
