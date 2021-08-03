class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        
        sol(list, l, 0, nums);
        
        return list;
        
    }
    
    public void sol(List<List<Integer>> list, ArrayList<Integer> l, int start, int[] nums)
    {
        list.add(new ArrayList<>(l));
        for(int i = start; i < nums.length; i++)
        {
            if(i == start || nums[i] != nums[i-1]){
            l.add(nums[i]);
            sol(list, l, i+1, nums);
            l.remove(l.size() - 1);
            }
        }
    }
}