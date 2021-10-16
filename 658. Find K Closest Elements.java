class Solution {
    
    class Pair implements Comparable<Pair>{
        int val;
        int gap;
        Pair(){}
        
        Pair(int val, int gap)
        {
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair p){
            if(this.gap == p.gap)
                return this.val - p.val;
            else
                return this.gap - p.gap;
        }
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        /* O(nlogk) */
        for(int i = 0; i < arr.length; i++)
        {
            if(pq.size() < k)
            {
                pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
            }
            else
            {
                if(pq.peek().gap > Math.abs(x - arr[i]))
                {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
                }
            }
        }
        
        while(pq.size() > 0)
        {
            res.add(pq.remove().val);
        }
        /* O(klogk) */
        Collections.sort(res);
        return res;
        
    }
}
