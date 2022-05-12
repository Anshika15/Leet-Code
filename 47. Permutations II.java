class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        Arrays.sort(nums);
        
        solution(nums, new boolean[nums.length], result, new ArrayList<>());
        
        return result;
        
    }
    
    void solution(int[] nums, boolean[] vis, List<List<Integer>> result, ArrayList<Integer> smallAns)
    {
        if(smallAns.size() == nums.length)
        {
            result.add(new ArrayList<>(smallAns));
            return;
        }
        
        for(int j = 0; j < nums.length; j++)
        {
            if(!vis[j]){
                if(j != 0 && nums[j] == nums[j-1] && vis[j-1])
                    return;

                vis[j] = true;
                smallAns.add(nums[j]);
                solution(nums, vis, result, smallAns);
                smallAns.remove(smallAns.size() - 1);
                vis[j] = false;
            }
        }
    }
}
