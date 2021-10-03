class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    
    int dirs[][] = {{1,0}, {-1,0}, {0,1},{0,-1}};
    
    public int shortestBridge(int[][] grid) {
        boolean flag = false;
        LinkedList<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length && !flag; i++)
        {
            for(int j = 0; j < grid[0].length && !flag; j++)
            {
                if(grid[i][j] == 1){
                    dfs(i, j, grid, vis, q);
                    flag = true;
                }
            }
        }
        
        int level = 0;
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                for(int i = 0; i < 4; i++)
                {
                    int rowdash = dirs[i][0] + rem.i;
                    int coldash = dirs[i][1] + rem.j;
                    
                    if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || vis[rowdash][coldash])
                        continue;
                    
                    if(grid[rowdash][coldash] == 1)
                        return level;
                    
                    q.add(new Pair(rowdash, coldash));
                    vis[rowdash][coldash] = true;
                    
                }
            }
             level++;
        }
        
        return -1;
        
        
    }
    
    public void dfs(int i, int j, int[][] grid, boolean vis[][], LinkedList<Pair> q)
    {
        vis[i][j] = true;
        q.addLast(new Pair(i, j));
        for (int val = 0; val < 4; val++)
        {
          int rowdash = i + dirs[val][0];
          int coldash = j + dirs[val][1];
          if (rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || vis[rowdash][coldash] == true || grid[rowdash][coldash] == 0)
            continue;

          dfs(rowdash, coldash,grid, vis, q);
        }
    }
    
    
}
