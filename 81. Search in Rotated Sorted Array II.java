class Solution {
    public boolean search(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high)
        {
            while (low < high && nums[low] == nums[low+1]) low++; //To skip the duplicates number in start
            while (low < high && nums[high] == nums[high - 1]) --high; //To skip the duplicates number in end
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return true;
            if(nums[low] <= nums[mid])
            {
                // checking low to mid part is sorted
                if(target >= nums[low] && target <= nums[mid])
                {
                    // then our value lies in this range only so search here
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else if(nums[mid] <= nums[high]) // check whether mid to high part is sorted
            {
                if(target >= nums[mid] && target <= nums[high])
                {
                    // then our value lies in this range only so search here
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
           
        }
       
        return false;
    }
}
