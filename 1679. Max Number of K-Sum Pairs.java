class Solution {
    public int maxOperations(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        
        for(int val : nums)
        {
            if(map.containsKey(k - val) && map.get(k - val) > 0)
            {
                map.put(k - val, map.get(k-val) - 1);
                c++;
            }
            else
                map.put(val, map.getOrDefault(val,0)+1);
        }
        
        return c;
        
    }
}
