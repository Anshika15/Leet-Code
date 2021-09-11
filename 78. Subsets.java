class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        solution(nums, 0, nums.length - 1, res, new ArrayList<>());
        
        return res;
        
    }
    
    public void solution(int[] nums, int idx, int end, List<List<Integer>> res, ArrayList<Integer> l)
    {
        
        res.add(new ArrayList<>(l));
        
        for(int i = idx; i <= end; i++)
        {
            l.add(nums[i]);
            solution(nums, i+1, end, res, l);
            l.remove(l.size() - 1);
        }
        
    }
}
