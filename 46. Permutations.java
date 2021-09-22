class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        solution(nums, new ArrayList<Integer>());
        return res;
    }
    
    public void solution(int[] nums, ArrayList<Integer> l)
    {
        if(l.size() == nums.length)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(l.contains(nums[i]))
                continue;
            l.add(nums[i]);
            solution(nums, l);
            l.remove(l.size() - 1);
        }
    }
}
