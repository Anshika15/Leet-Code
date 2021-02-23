class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        
        int t[] = new int[nums.length];
        t[0] = nums[0];
        int max = t[0];
        for(int i = 1; i < nums.length; i++)
        {
            t[i] = Math.max(nums[i], t[i-1] + nums[i]);
            max = Math.max(max, t[i]);
        }
        return max;
    }
}
