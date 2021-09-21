class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int res = 0;
        int c = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                c++;
                res = Math.max(c, res);
            }
            else
                c = 0;
        }
        
        return res;
        
    }
}
