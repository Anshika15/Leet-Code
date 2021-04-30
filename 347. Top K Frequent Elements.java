class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
            {
                int c = map.get(nums[i]);
                map.put(nums[i], c+1);
            }
        }
        System.out.println(map);
        
        Queue<Integer> q = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for(int i : map.keySet())
        {
            q.add(i);
            if(q.size() > k)
                q.poll();
        }
        System.out.println(q);
        
        int res[] = new int[k];
        for(int i = k-1; i >= 0; i--)
        {
            res[i] = q.poll();
        }
        return res;
    }
}
