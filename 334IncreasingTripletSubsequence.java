class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            if(min >= nums[i])
                min = nums[i];
            else if(max >= nums[i])
                max = nums[i];
            else return true;
        }
        return false;
    }
}
