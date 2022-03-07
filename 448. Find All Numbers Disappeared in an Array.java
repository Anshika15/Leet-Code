class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int val : nums){
            set.add(val);  
        }
        
        for(int i = 1; i <= n; i++)
        {
            if(!set.contains(i))
                res.add(i);
        }
        return res;
    }
}
