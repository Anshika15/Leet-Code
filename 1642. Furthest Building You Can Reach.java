class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int idx = 0; idx < heights.length-1; idx++)
        {
            int dist = heights[idx+1] - heights[idx];
            if(dist > 0)
                pq.add(dist);
            if(pq.size() > ladders)
                bricks -= pq.poll();
            if(bricks < 0)
                return idx;
            
        }
        return heights.length - 1;
    }
}
