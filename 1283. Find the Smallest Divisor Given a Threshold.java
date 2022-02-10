class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
     // we will keep our max divisor as the max element in array after that 
        // use binary search to find the lowest possible divisor so that our ans <= threshold

        int max = nums[0];
        int lo = 1;

        for(int i = 1; i < nums.length; i++)
        {
            max = Math.max(max, nums[i]);
        }

        if(threshold == nums.length)
            return max;
        int hi = max;
        int minDiv = Integer.MAX_VALUE;
        while(lo <= hi)
        {
            int div = lo + (hi - lo)/2;

            if(isPossible(div, nums, threshold))
            {
                minDiv = div;
                hi = div - 1;
            }
            else
            {
                lo = div+1;
            }
        }
        return minDiv;
    }

    public boolean isPossible(int div, int[] nums, int th)
    {
        int res = 0;

        for(int i = 0; i < nums.length; i++)
        {
            res += Math.ceil(nums[i]*1.0/div);
        }
        return res <= th;
    }
}
