class Solution {
    public int findMin(int[] nums) {
        
        
         int i = 0; int j = nums.length-1;
        
         if(nums[i] <= nums[j])
            return nums[0]; // arr is already sorted
        
        while(i <= j)
        {
            int mid = i + (j-i)/2;
            if(nums[mid] > nums[mid+1])
                return nums[mid+1];
            else if(nums[mid] < nums[mid-1])
                return nums[mid];
            else if(nums[i] <= nums[mid])
                i = mid+1;
            else
                j = mid-1;
        }
        return -1;
    }
}
