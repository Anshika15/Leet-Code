class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character, Integer>, ArrayList<String>> rmap = new HashMap<>();
        
        for(String str : strs)
        {
            HashMap<Character, Integer> map = new HashMap<>();
            
            for(char ch : str.toCharArray())
            {
                map.put(ch, map.getOrDefault(ch,0)+1);   
            }
            
            if(rmap.containsKey(map))
            {
                ArrayList<String> l = rmap.get(map);
                l.add(str);
            }
            else
            {
                ArrayList<String> l = new ArrayList<>();
                l.add(str);
                rmap.put(map, l);
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        
        for(ArrayList<String> l : rmap.values())
            list.add(l);
        return list;
        
    }
}
