class Solution {
    public int minMoves2(int[] nums) {
        
        int count = 0;
        int start = 0; int end = nums.length - 1;
        Arrays.sort(nums);
        while(start < end)
        {
            count += nums[end] - nums[start];
            start++;
            end--;
        }
        return count;
    }
}
