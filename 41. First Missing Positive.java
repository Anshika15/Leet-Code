class Solution {
    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        
        int res = 1;
        while(set.contains(res))
            res++;
        return res;
    }
}
