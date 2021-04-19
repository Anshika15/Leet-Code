class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int t[] = new int[target+1];
        t[0] = 1;
        
        for(int i = 1; i < t.length; i++)
        {
            for(int j = 0; j < nums.length; j++)
            {
                if(i - nums[j] >= 0)
                    t[i] += t[i-nums[j]];
            }
        }
        return t[target];
    }
}
