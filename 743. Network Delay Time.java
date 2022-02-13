class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<Pair>[] g = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();
        for(int i = 0; i < times.length; i++)
        {
            int src = times[i][0];
            int dest = times[i][1];
            int wt = times[i][2];
            
            g[src].add(new Pair(src, dest, wt));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(k, 0, 0));
        int ans = 0;
        HashSet<Integer> vis = new HashSet<>();
        
        while(q.size() > 0)
        {
            Pair rem = q.remove();
            if(vis.contains(rem.u))
                continue;
            vis.add(rem.u);
            if(vis.size() == n)
                return rem.wt;
            for(Pair e : g[rem.u])
            {
                if(!vis.contains(e.v))
                    q.add(new Pair(e.v, 0, rem.wt + e.wt));
            }
            
        }
        return -1;
        
    }
    
    class Pair implements Comparable<Pair>{
        int u;
        int v;
        int wt;
        
        Pair(){}
        Pair(int u, int v, int wt)
        {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Pair p)
        {
            return this.wt - p.wt;
        }
    }
}
