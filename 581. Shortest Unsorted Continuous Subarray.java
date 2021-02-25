class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int hi = -1;
        int li = -1;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            mx = Math.max(mx, nums[i]);
           // System.out.println(mx);
            if(nums[i] < mx)
            {
                System.out.println(nums[i]);
                hi = i;
            }
                
        }
        System.out.println("-----");

        for(int i = nums.length - 1; i >= 0; i--)
        {
            mn = Math.min(mn, nums[i]);
            //System.out.println(mn);
            if(nums[i] > mn)
            {
                System.out.println(nums[i]);
                li = i;
            }
        }
        System.out.println(mx + " " + mn);
        return li == -1 ? 0 : hi-li+1;
    }
}
