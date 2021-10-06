class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>(); // element, frequency
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i : map.keySet())
        {
           if(map.get(i) > 1)
           {
               list.add(i);
           }
        }
        
        return list;
    }
}
