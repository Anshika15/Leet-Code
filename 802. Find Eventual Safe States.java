class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        int[] outdegree = new int[graph.length];
        
        for(int i = 0; i < graph.length; i++)
        {
            map.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < graph.length; i++)
        {
            for(int j = 0; j < graph[i].length; j++)
            {
                int src = i;
                int dest = graph[i][j];
                
                map.get(dest).add(src);
                outdegree[i]++;
            }
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i++)
        {
            if(outdegree[i] == 0){
                q.add(i);
            }
        }
        
        boolean vis[] = new boolean[graph.length];
        
        while(q.size() > 0)
        {
            int rem = q.removeFirst();
            if(vis[rem])
                continue;
            vis[rem] = true;
            
            res.add(rem);
            
            for(int nbr : map.get(rem))
            {
                outdegree[nbr]--;
                if(outdegree[nbr] == 0)
                    q.add(nbr);
            }
        }
        Collections.sort(res);
        return res;
        
    }
}
