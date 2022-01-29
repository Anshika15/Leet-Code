class Solution {
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges, (a,b) -> Integer.compare(b[0], a[0]));
        int counta = 1; // number of elements connected for alice
        int countb = 1; // number of lements connected for bob
        
        int remove = 0;
        
        int[] parenta = new int[n+1];
        int[] ranka = new int[n+1];
        
        int[] parentb = new int[n+1];
        int[] rankb = new int[n+1];
        
        for(int i = 0; i < n+1; i++)
        {
            parenta[i] = i;
            ranka[i] = 1;
            
            parentb[i] = i;
            rankb[i] = 1;
        }
        
        for(int i = 0; i < edges.length; i++)
        {
            int type = edges[i][0];
            if(type == 3)
            {
                boolean flaga = union(edges[i][1], edges[i][2], parenta, ranka);
                boolean flagb = union(edges[i][1], edges[i][2], parentb, rankb);
                if(flaga == true)
                {
                    counta++;
                }
                if(flagb == true)
                {
                    countb++;
                }
                if(flaga == false && flagb == false)
                {
                    remove++;
                }
            }
            else if(type == 2)
            {
                
                boolean flagb = union(edges[i][1], edges[i][2], parentb, rankb);
               
                if(flagb == true)
                {
                    countb++;
                }
                if(flagb == false)
                {
                    remove++;
                }
            }
            else if(type == 1)
            {
                boolean flaga = union(edges[i][1], edges[i][2], parenta, ranka);
                if(flaga == true)
                {
                    counta++;
                }
                if(flaga == false)
                {
                    remove++;
                }
            }
        }
        
        if(counta != n || countb != n)
            return -1;
        return remove;
        
    }
    
    boolean union(int x, int y, int[] parent, int[] rank)
    {
        int lx = find(x, parent);
        int ly = find(y, parent);
        
        if(lx != ly)
        {
            if(rank[lx] > rank[ly])
                parent[ly] = lx;
            else if(rank[lx] < rank[ly])
                parent[lx] = ly;
            else
            {
                parent[ly] = lx;
                rank[lx]++;
            }
            return true;
        }
        return false;
    }
    
    int find(int x, int[] parent)
    {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

}
