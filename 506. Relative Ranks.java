class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++)
        {
            pq.add(new Pair(i, score[i]));
        }
        
        String res[] = new String[score.length];
        int idx = 0;
        while(pq.size() > 0)
        {
            Pair rem = pq.remove();
            if(idx == 0)
            {
                res[rem.idx] = "Gold Medal";
                idx++;
            }
            else if(idx == 1)
            {
                res[rem.idx] = "Silver Medal";
                idx++;
            }
            else if(idx == 2)
            {
                res[rem.idx] = "Bronze Medal";
                idx++;
            }
            else
            {
                res[rem.idx] = Integer.toString(idx+1);
                idx++;
            }
        }
        return res;
    }
    
    class Pair implements Comparable<Pair>{
        int idx;
        int val;
        
        Pair(){}
        
        Pair(int idx, int val)
        {
            this.idx = idx;
            this.val = val;
        }
        
        public int compareTo(Pair p)
        {
            return p.val - this.val;
        }
    }
}
