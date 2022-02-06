class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length <= 2)
            return nums.length;
        int idx = 2;
        for(int j = 2; j < nums.length; j++)
        {
            if(nums[j] != nums[idx-2])
            {
                nums[idx] = nums[j];
                idx++;
            }
        }
        
        return idx;
        
    }
}
