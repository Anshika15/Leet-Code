class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for(int i = 0; i < grid2.length; i++)
        {
            for(int j = 0; j < grid2[0].length; j++)
            {
                if(grid2[i][j] == 1){
                    ArrayList<Pair> l = new ArrayList<>();
                    dfs(grid2, l, i, j);
                    list.add(l);
                }
            }
        }
        
        int res = 0;
        for(int i = 0; i < list.size(); i++)
        {
            boolean flag = false;
            for(Pair p : list.get(i))
            {
                if(grid1[p.row][p.col] == 1)
                   continue;
                flag = true;
            }
            if(flag == false)
                res++;
        }
        return res;
    }
    
   void dfs(int[][] g, ArrayList<Pair> l, int i, int j)
   {
       int n = g.length;
       int m = g[0].length;
       if(i < 0 || j < 0 || i >= n || j >= m || g[i][j] == 0)
           return;
       g[i][j] = 0;
       l.add(new Pair(i,j));
       
       dfs(g, l, i+1,j);
       dfs(g, l, i-1,j);
       dfs(g, l, i,j+1);
       dfs(g, l, i,j-1);
   }
    
    
    class Pair{
        int row;
        int col;
        Pair(){};
        
        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
}
