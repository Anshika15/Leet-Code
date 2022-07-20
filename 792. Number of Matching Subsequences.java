class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);
        
        char[] strArray = s.toCharArray();
        int count = 0;
        for(String word : map.keySet())
        {
            char[] wordArray = word.toCharArray();
            int i = 0; int j = 0;
            while(i < strArray.length && j < wordArray.length)
            {
                if(strArray[i] == wordArray[j])
                {
                    i++;
                    j++;
                }
                else
                {
                    i++;
                }
            }
            
            if(j == wordArray.length)
                count += map.get(word);
        }
        return count;
        
    }
}
