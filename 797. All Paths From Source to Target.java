class Solution {
    
    public List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        dfs(graph, l, 0, graph.length - 1);
        
        return list;
    }
    
    public void dfs(int[][] graph, List<Integer> l, int src, int dest){
        
        if(src == dest)
        {
            list.add(new ArrayList<Integer>(l));
            return;
        }
        

        for(int nbr: graph[src])
        {
          
            l.add(nbr);
            dfs(graph, l, nbr, dest);
            l.remove(l.size() - 1);
          
        }
      
    }
}