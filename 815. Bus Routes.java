class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        int n = routes.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // bus stop -> [bus numbers]
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < routes[i].length; j++)
            {
                /* i represents bus number */
                int busStop = routes[i][j];
                ArrayList<Integer> busNums = map.getOrDefault(busStop, new ArrayList<>());
                busNums.add(i);
                map.put(busStop, busNums);
            }
        }
        
        HashSet<Integer> busNumVis = new HashSet<>();
        HashSet<Integer> busStopVis = new HashSet<>();
        
        LinkedList<Integer> q = new LinkedList<>();
        
        q.add(source);
        int level = -1;
        while(q.size() > 0)
        {
            level++;
            int size = q.size();
            while(size-- > 0)
            {
                int rem = q.removeFirst();
                if(rem == target)
                    return level;
                
                ArrayList<Integer> busNums = map.get(rem);
                for(int busNum : busNums)
                {
                    if(busNumVis.contains(busNum))
                        continue;
                    int busStops[] = routes[busNum];
                    for(int busStop : busStops)
                    {
                        if(busStopVis.contains(busStop))
                            continue;
                        q.add(busStop);
                        busStopVis.add(busStop);
                    }
                    busNumVis.add(busNum);
                }     
            }
        }
        return -1;
    }
}
