class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        
        if(nums.length < 3)
            return new ArrayList<>(res);
         
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            int left = i+1; int right = nums.length - 1;
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                }
                else if(sum > 0)
                    right--;
                else if(sum < 0)
                    left++;
            }
            
        }
        return new ArrayList<>(res);
    }
}
