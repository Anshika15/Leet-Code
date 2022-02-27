class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        
        List<String> res = new ArrayList<>(map.keySet());
        
        Collections.sort(res, (w1, w2) ->{
            if(map.get(w1) == map.get(w2))
                return w1.compareTo(w2); // smaller word
            else
                return map.get(w2) - map.get(w1); // higher freq
        });
        
        return res.subList(0, k);
    }
    
    
}
