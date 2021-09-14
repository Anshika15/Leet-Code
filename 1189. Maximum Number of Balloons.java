class Solution {
    public int maxNumberOfBalloons(String text) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        String str = "balloon";
        for(char ch : str.toCharArray())
        {
            map.put(ch, 0);
        }
        
        for(char ch : text.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch)+1);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(char ch : map.keySet())
        {
            if(ch == 'l' || ch == 'o')
            {
                min = Math.min(map.get(ch)/2, min);
            }
            if(map.get(ch) < min)
            {
                min = map.get(ch);
            }
        }
        
        return min;
    }
}
