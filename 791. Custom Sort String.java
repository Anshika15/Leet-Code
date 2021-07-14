class Solution {
    public String customSortString(String order, String str) {
        
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character ch : str.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        // System.out.println(map);
        
        for(Character ch : order.toCharArray())
        {
           if(map.containsKey(ch))
           {
               for(int i = 0; i < map.get(ch); i++)
               {
                   sb.append(ch);
               }
           }
            
           map.remove(ch);
        }
        
        // System.out.println(map);
        
        for(Character ch : map.keySet())
        {
          for(int i = 0; i < map.get(ch); i++)
               {
                   sb.append(ch);
               }
        }
        
        
        return sb.toString();
        
    }
}