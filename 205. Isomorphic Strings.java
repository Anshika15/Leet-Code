class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character, Character> map1 = new HashMap<>(); // map s1 char with s2

		HashMap<Character, Boolean> map2 = new HashMap<>(); // whether we can use s2 char or not

		for(int i = 0; i < s.length(); i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1))
            {
                if(map1.get(ch1) != ch2)
                    return false;
            }
            else
            {
                if(map2.containsKey(ch2)){
                    return false;
                }
                else
                {
                    map1.put(ch1, ch2); // map the char 1 with char2
                    map2.put(ch2, true); // marks char2 as visited
                }
            }
        }
		return true;
        
    }
}
