class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr)
        {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int key : map.keySet())
        {
            pq.add(new Pair(key, map.get(key)));
        }
        
        int size = arr.length;
        int result = 0;
        while(size > arr.length/2)
        {
            Pair p = pq.poll();
            size -= p.count;
            result++;
        }
        return result;
        
    }
    
    class Pair implements Comparable<Pair>{
        
        int val;
        int count;
        
        Pair(){}
        
        Pair(int val, int count)
        {
            this.val = val;
            this.count = count;
        }
        
        public int compareTo(Pair p)
        {
            return p.count - this.count;
        }
        
        public String toString()
        {
            return this.val + " - " + this.count;
        }
        
    }
}
