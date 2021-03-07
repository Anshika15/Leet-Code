class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Set<String> set = new HashSet<>(Arrays.asList(words));
        
        for(String w: words)
        {
            if(set.contains(w))
            {
                for(int i = 1; i < w.length(); i++) // remove suffixes
                    set.remove(w.substring(i));
            }
        }
        int res = set.size();
        for(String w: set)
            res += w.length();
        return res;
        
        
    }
}
