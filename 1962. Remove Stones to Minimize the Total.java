class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int pile : piles)
        {
            pq.add(pile);
        }

        while(k-- > 0 && pq.size() > 0)
        {
            int top = pq.poll();
            top = top - top/2;
            pq.add(top);
        }

        int result = 0;

        while(pq.size() > 0)
        {
            result += pq.poll();
        }

        return result;
        
    }
}
