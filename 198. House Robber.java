class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int t[] = new int[nums.length+1];
        t[0] = 0;
        t[1] = nums[0];
        t[2] = Math.max(t[1], t[2]);
        for(int i = 2; i <= nums.length; i++)
        {
            t[i] = Math.max(t[i-1], nums[i-1] + t[i-2]);
        }
        
        return t[nums.length];
    }
}
