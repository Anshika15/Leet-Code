class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int positive = 1;
        int negative = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            int newPositive = 0;
            int newNegative = 0;
            if(nums[i-1] < nums[i])
            {
                newPositive = negative + 1;
                newNegative = negative;
            }
            else if(nums[i-1] > nums[i])
            {
                newPositive = positive;
                newNegative = positive + 1;
            }
            else
            {
                newPositive = positive;
                newNegative = negative;
            }
            
            negative = newNegative;
            positive = newPositive;
        }
        
        return Math.max(negative, positive);
        
    }
}
