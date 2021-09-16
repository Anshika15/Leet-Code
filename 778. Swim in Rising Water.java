class Solution {
    public int swimInWater(int[][] grid) {
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        boolean vis[][] = new boolean[n][m];
        
        while(pq.size() > 0)
        {
            Pair rem = pq.remove();
            
            if(rem.row == n-1 && rem.col == m-1)
            {
                return rem.max;
            }
            if(vis[rem.row][rem.col] == true)
                continue;
            vis[rem.row][rem.col] = true;
            
            for(int i = 0; i < 4; i++)
            {
                int rowdash = rem.row + dirs[i][0];
                int coldash = rem.col + dirs[i][1];
                
                if(rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= m || vis[rowdash][coldash])
                    continue;
                pq.add(new Pair(rowdash, coldash, Math.max(rem.max, grid[rowdash][coldash])));
            }
        }
        
        return 0;
    }
    
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int max; // max so far
        Pair(int row, int col, int max)
        {
            this.row = row;
            this.col = col;
            this.max = max;
        }
        
        public int compareTo(Pair p)
        {
            return this.max - p.max;
        }
    }
}
