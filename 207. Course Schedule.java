class Solution {
    
    int E;
    int V;
    ArrayList<Integer> adj[];
    boolean vis[];
    boolean onpath[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        E = prerequisites.length;
        V = numCourses;
        
        adj = new ArrayList[numCourses];
        vis = new boolean[V];
		Arrays.fill(vis,  false);
        onpath = new boolean[V];
		Arrays.fill(onpath,  false);
        
        for(int i = 0; i < numCourses; i++)
        {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adj[src].add(dest);
        }
        
        for(int i = 0; i < V; i++)
            System.out.print(adj[i] + " ");
        
        boolean res = isCyclic();
        
        return !res;
        
    }
    
    boolean isCyclic()
    {
        for(int i = 0; i < V; i++)
        {
            if(vis[i] != true)
                if(dfs(i))
                    return true;
        }
        return false;
        
    }
    
    boolean dfs(int src)
    {
        if(vis[src] == true)
            return false;
        onpath[src] = vis[src] = true;
        for(int i = 0 ;i < adj[src].size(); i++)
        {
            if(onpath[adj[src].get(i)] == true)
                return true;
            else
                if(dfs(adj[src].get(i)))
                    return true;
        }
        onpath[src] = false;
        return false;
    }
	
}
