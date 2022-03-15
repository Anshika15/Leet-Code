class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int i = 1;
        int prev = nums[0];
        int len = 1;
        int j = 0;
        while(i < nums.length)
        {
            if(nums[i] > prev){
                 prev = nums[i];
            }
            else
            {
                len = Math.max(len, i-j);
                prev = nums[i];
                j = i;
            }
            i++;
        }
        len = Math.max(len, i-j);
        return len;
    }
}
