class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int val : nums1)
            set.add(val);
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : nums2)
        {
            if(set.contains(val))
            {
                list.add(val);
                set.remove(val);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
        
    }
}
