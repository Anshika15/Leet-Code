class Solution {
    public int minOperations(int[] nums, int x) {
        
        int target = -x;
        for(int val : nums)
            target += val;
        
        if(target == 0)
            return nums.length;
        
        int result = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // sum, index
        map.put(0, -1);
        for(int idx = 0; idx < nums.length; idx++)
        {
            sum += nums[idx];
            if(map.containsKey(sum - target))
                result = Math.max(idx - map.get(sum-target), result);
            if(!map.containsKey(sum))
                map.put(sum, idx);
        }
        
        if(result == Integer.MIN_VALUE)
            return -1;
        return nums.length - result;
        
    }
}
