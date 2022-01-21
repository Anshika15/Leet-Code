class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        List<Pair> list = new ArrayList<>();
        
        for(int i = 0; i < buildings.length; i++)
        {
            int start = buildings[i][0];
            int end = buildings[i][1];
            int ht = buildings[i][2];
            list.add(new Pair(start, -ht));
            list.add(new Pair(end, ht));
        }
        
        Collections.sort(list);
        int currht = 0;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++)
        {
            Pair p = list.get(i);
            int x = p.x;
            int ht = p.ht;
            if(ht < 0)
            {
                // start
                pq.add(-ht);
            }
            else
            {
                // end
                pq.remove(ht);
            }
            if(currht != pq.peek())
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());
                    
                ans.add(temp);
                currht = pq.peek();
            }
        }
        
        return ans;
        
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int ht;
        
        Pair(){}
        
        Pair(int x, int ht)
        {
            this.x = x;
            this.ht = ht;
        }
        
        public int compareTo(Pair p)
        {
            if(this.x != p.x)
                return this.x - p.x;
            else
                return this.ht - p.ht; // to remove redundancy
        }
    }
}
