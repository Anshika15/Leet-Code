class Solution {
    
    LinkedList<String> res;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        res = new LinkedList<>();
        
        for(List<String> ticket : tickets)
        {
            PriorityQueue<String> pq = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            pq.add(ticket.get(1));
            graph.put(ticket.get(0), pq);
        }
        
        dfs("JFK", graph);
        return res;
        
    }
    
    public void dfs(String src, HashMap<String, PriorityQueue<String>> graph)
    {
        PriorityQueue<String> pq = graph.get(src); // neighbours
        while(pq != null && pq.size() > 0)
        {
            String nbr = pq.remove();
            dfs(nbr, graph);
        }
        res.addFirst(src);
    }
}
