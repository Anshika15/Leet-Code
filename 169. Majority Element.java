class Solution {
    public int majorityElement(int[] nums) {
        
        int val1 = nums[0];
        int count = 1;
    
        for(int i = 0; i < nums.length; i++)
        {
            if(val1 == nums[i])
                count++;
            else
                count--;
            if(count == 0)
            {
                val1 = nums[i];
                count++;
            }
        }
        return val1;
    }
}
