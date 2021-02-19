class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < stones.length; i++)
            heap.add(stones[i]);
        
        System.out.println(heap);
        
        while(heap.size() >= 1)
        {
            if(heap.size() == 1)
                return heap.poll();
            else
            {
                int first = heap.poll();
                int second = heap.poll();
                if(first != second)
                    heap.add(first - second);
            }
        }
        return 0;
    }
}
