class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        /* minimise the brick crossing == maximising the split crossing */
        
        /* coordinate - split count */
        /* coordinate == prefix sum in a row */
        /* we will not go till last index in a row as we have to split in between not at end */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < wall.size(); i++)
        {
            int prefsum = 0;
            for(int j = 0; j < wall.get(i).size() - 1; j++)
            {
                prefsum += wall.get(i).get(j);
                map.put(prefsum, map.getOrDefault(prefsum, 0)+1);
                max = Math.max(max, map.get(prefsum));
            }
        }
        
        return wall.size() - max;
        
        
        /* ans == min brick crosisng == total - max brick spliting */
        
    }
}
