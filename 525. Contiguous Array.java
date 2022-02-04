class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); // sum, idx
        
        map.put(0, -1);
        
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
              sum += -1;
            else
                sum += 1;
            if(map.containsKey(sum))
            {
                int len = i - map.get(sum);
                ans = Math.max(len, ans);
            }
            else
            {
                map.put(sum, i);
            }
        }
        return ans;
        
    }
}
