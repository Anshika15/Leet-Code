class Solution {
    public int findMin(int[] nums) {
        
        /* O(n) */
//         if(nums.length == 1)
//             return nums[0];
//         if(nums.length == 2)
//             return Math.min(nums[0], nums[1]);
//         int min = nums[0];
//         for(int i = 0; i < nums.length; i++)
//         {
//             min = Math.min(nums[i], min);
//         }
//         return min;
        
        /* O(logn) */
        
        int i = 0; int j = nums.length-1;
       
        while(i <= j)
        {
            int mid = i + (j-i)/2;
            if(nums[mid] > nums[j])
                i = mid+1;
            else if(nums[mid] < nums[j])
                j = mid;
            else
                j--;
        }
        return nums[i];
        
    }
}
