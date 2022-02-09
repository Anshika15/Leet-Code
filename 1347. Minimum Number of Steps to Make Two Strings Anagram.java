class Solution {
    public int minSteps(String s, String t) {
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
            
            ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        
        int ans = 0;
        
        for(char key : map1.keySet())
        {
            int freq1 = map1.get(key);
            int freq2 = map2.getOrDefault(key, 0);
            if(freq2 < freq1)
                ans += Math.abs(freq2 - freq1);
        }
        return ans;
    }
}
