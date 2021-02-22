class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int res[] = new int[nums.length - k + 1];
        int r = 0;
        int j = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(j < nums.length)
        {
            while(q.size() > 0 && q.getLast() < nums[j])
                q.removeLast();
            q.add(nums[j]);
            if(j - i + 1 < k)
                j++;
            else if(j - i + 1 == k)
            {
                res[r] = q.getFirst();
                r++;
                if(q.getFirst() == nums[i])
                    q.removeFirst();
                i++;
                j++;
            }                  
         }
        return res;
    }
}
