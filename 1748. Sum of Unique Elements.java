class Solution {
    public int sumOfUnique(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        int res = 0;
        for(int key : map.keySet())
        {
            if(map.get(key) == 1)
                res += key;
        }
        return res;
        
    }
}
