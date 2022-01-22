class Solution {

    HashMap<Integer, Integer> map; // mapping the blaclisted with non blacklisted
      Random random;
      int top;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        top = n - blacklist.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < blacklist.length; i++)
        {
            set.add(blacklist[i]);
        }
        n--;
        for(int i = 0; i < blacklist.length; i++)
        {
            
            if(blacklist[i] < top){
                while(set.contains(n))
                    n--;
            
                map.put(blacklist[i], n); 
                n--;
            }
        }
    }
    
    public int pick() {
        
        int randomIdx = random.nextInt(top);
        
        if(map.containsKey(randomIdx)) // it is blacklisted so instead return the mapped val
        {
            return map.get(randomIdx);
        }
        return randomIdx;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
