class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        if(nums.length == 1)
        {
            res.add(nums[0] + "");
            return res;
        }
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            while(i+1 < nums.length && nums[i+1] == nums[i]+1)
            {
                end++;
                i++;
            }
            if(start == end)
            {
                res.add(nums[start] + "");
            }
            else
            {
                res.add(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;
        }
        
        return res;
        
    }
}
