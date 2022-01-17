class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++)
        {
            char ch = pattern.charAt(i);
            
            if(!map.containsKey(ch))
            {
                if(used.containsKey(words[i]))
                    return false;
                else
                {
                    map.put(ch, words[i]);
                    used.put(words[i], true);
                }
            }
            else
            {
                String word = map.get(ch);
                if(!words[i].equals(word))
                    return false;
            }
        }
        return true;
    }
}
