class Solution {
     public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> rainMap = new HashMap<>(); // store the rain lake and index
        
        /* in set we will store the dry days */
        TreeSet<Integer> set = new TreeSet<>(); // dry day index
        int n = rains.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            int x = rains[i];
            if(x == 0)
            {
                set.add(i);
                ans[i] = 1; // keep any default value
            }
            else
            {
                Integer id = rainMap.get(x); // check if x has occured before or not
                if(id == null) // first time occuring
                {
                  rainMap.put(x, i);  
                }
                else
                {
                    /* The higher() is a method of TreeSet class. This method returns the smallest element in the set which is greater than the element in the argument, else it will return null if the element is not present. */
                    
                    Integer dryId = set.higher(id);
                    if(dryId == null)
                    {
                        // can't atop flood
                        return new int[0];
                    }
                    ans[dryId] = x;
                    set.remove(dryId);
                    rainMap.put(x, i);
                    
                }
                ans[i] = -1;
            }
        }
        
        return ans;
     }
}
