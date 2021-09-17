class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++)
        {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(map1.containsKey(nums2[i])){
                res.add(nums2[i]);
                if(map1.get(nums2[i]) == 1)
                    map1.remove(nums2[i]);
                else
                {
                    map1.put(nums2[i], map1.get(nums2[i])-1);
                }
            }
        }
        
       int[] arr = new int[res.size()];
       for(int i = 0; i < res.size(); i++)
       {
           arr[i] = res.get(i);
       }
        
       return arr; 
        
    }
}
