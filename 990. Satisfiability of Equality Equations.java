class Solution {
    
    int[] parent;
    int[] rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i = 0; i < 26; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(String str : equations)
        {
            char ch1 = str.charAt(1);
            if(ch1 == '=')
            {
                union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        
        for(String str : equations)
        {
            char ch1 = str.charAt(1);
            if(ch1 == '!')
            {
                int l1 = find(str.charAt(0) - 'a');
                int l2 = find(str.charAt(3) - 'a');
                if(l1 == l2)
                    return false;
            }
        }
        
        return true;
    }
    
    void union(int x, int y)
    {
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly)
        {
            if(rank[lx] > rank[ly])
                parent[ly] = lx;
            else if(rank[lx] > rank[ly])
                parent[ly] = lx;
            else
            {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
    
    int find(int x)
    {
        if(x == parent[x])
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
}
