class Solution {
    
    int[] parent;
    int rank[];
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i < pairs.size(); i++)
        {
            union(pairs.get(i).get(0), pairs.get(i).get(1));
        }
        
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }
       
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            sb.append(map.get(find(i)).remove());
        }
        return sb.toString();
    }
    
    public int find(int x)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y)
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
        }
    }
    
}
