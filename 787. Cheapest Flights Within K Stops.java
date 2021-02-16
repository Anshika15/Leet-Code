class Solution {
    
    ArrayList<Integer> adj[];
    int cost[][];
    int fare = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        adj = new ArrayList[n];
        cost = new int[n][n];
        
        for(int[] row : cost)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < flights.length; i++)
        {
            int sr = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            adj[sr].add(dest);
            
            cost[sr][dest] = wt;
        }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                System.out.print(cost[i][j] + " " );
        
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);
        
        solve(src, dst, 0, K, vis);
        if(fare == Integer.MAX_VALUE)
            return -1;
        return fare;
        
    }
    
    void solve(int src, int dest, int totalcost, int k, boolean vis[])
    {
        if(k < -1)
            return;
        if(src == dest)
        {
            fare = Math.min(fare, totalcost);
            return;
        }
        vis[src] = true;
        for(int i : adj[src])
        {
            if(!vis[i] && (totalcost + cost[src][i]) <= fare)
                solve(i, dest, totalcost + cost[src][i], k-1, vis);
        }
        vis[src] = false;
    }
}
