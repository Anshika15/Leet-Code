class Solution {
    public int minimumDeviation(int[] nums) {
        
        /* 
        
        Make all odd values even

        Take minimum of all values

        Find Max & difference & update max/2, till the max is even

        Otherwise difference is the result
        
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        
        for(int val : nums)
        {
            if(val%2 != 0)
                val = val*2; // multiplying odd vals with 2 will make them even
            pq.add(val);
            min = Math.min(min, val);
        }
        
        int diff = Integer.MAX_VALUE;

        while(pq.peek()%2 == 0) // peek val is max as we have created max heap
        {
            int max = pq.remove();
            diff = Math.min(diff, max - min);
            min = Math.min(min, max/2); // there are chances that our min value is now changed
            pq.add(max/2);
        }
        
        return Math.min(pq.peek() - min, diff);
        
    }
}
