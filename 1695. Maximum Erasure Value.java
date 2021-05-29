class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        
        while(i < nums.length && j < nums.length)
        {
            if(!set.contains(nums[j]))
            {
                sum += nums[j];
                ans = Math.max(ans, sum);
                set.add(nums[j]);
                j++;
            }
            else
            {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return ans;
        
    }
}
