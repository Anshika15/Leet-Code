class Solution {
    
    int[] parent;
    int[] rank;
    
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
    
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                pq.add(new Pair(i, j, findDistance(points[i], points[j])));
            }
        }
        
        int count = 0;
        int ans = 0;
        while(count < n-1)
        {
            Pair p = pq.remove();
            if(union(p.u, p.v))
            {
                ans += p.wt;
                count++;
            }
        }
        return ans;
     
    }
    
    class Pair implements Comparable<Pair>{
        int u;
        int v;
        int wt;
        
        Pair(int u, int v, int wt)
        {
            this.u =u;
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Pair p)
        {
            return this.wt - p.wt;
        }
    }
    
    int findDistance(int[] a, int[] b)
    {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    
    boolean union(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly)
        {
            if(rank[lx] > rank[ly])
            {
                parent[ly] = lx;
            }
            else if(rank[lx] < rank[ly])
            {
                parent[lx] = ly;
            }
            else
            {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }
    
    int find(int x)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
}
