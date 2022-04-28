class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        
        int n = heights.length-1;
        int m = heights[0].length-1;
        LinkedList<Pair> pq = new LinkedList<>();
        pq.add(new Pair(0,0,0));
        
        int max[][] = new int[n+1][m+1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(max[i], Integer.MAX_VALUE);
        max[0][0] = 0;
        
        while(pq.size() > 0)
        {
            Pair rem = pq.removeFirst();
            if(max[rem.x][rem.y] < rem.msf)
                continue;
            
            for(int i = 0; i < 4; i++)
            {
                int row = dirs[i][0] + rem.x;
                int col = dirs[i][1] + rem.y;
                
                if(row < 0 || col < 0 || row > n || col > m)
                    continue;
               
                int val = Math.max(rem.msf, Math.abs(heights[rem.x][rem.y] - heights[row][col]));
                if(max[row][col] > val){
                    max[row][col] = val;
                    pq.add(new Pair(row, col, val));
                }
            }
            
        }
        return max[n][m];
    }
    
    class Pair {
        int x;
        int y;
        int msf;
        
        Pair(int x, int y, int msf)
        {
            this.x = x;
            this.y = y;
            this.msf = msf;
        }    
    }

}
