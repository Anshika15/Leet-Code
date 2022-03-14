class KthLargest {

    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>(k);
        K = k;
        for(int val : nums)
            add(val);
    }
    
    public int add(int val) {
         if (pq.size() < K)
            pq.offer(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
