class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] res = new int[n][m];
        
        for(int i = 0; i < n; i++)
            Arrays.fill(res[i], -1);
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(isWater[i][j] == 1)
                    res[i][j] = 0;
            }
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(res[i][j] == 0)
                    q.add(new Pair(i,j, 0));
            }
        }
        
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove();
                
                for(int i = 0; i < 4; i++)
                {
                    int row = rem.x + dirs[i][0];
                    int col = rem.y + dirs[i][1];
                    
                    if(row < 0 || col < 0 || row >= n || col >= m || res[row][col] != -1)
                        
                        continue ;
                    res[row][col] = rem.val+1;
                    q.add(new Pair(row, col, rem.val+1));
                }
            }
            
        }
        return res;
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int val;
        Pair(){}
        Pair(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        public int compareTo(Pair p)
        {
            return this.val - p.val;
        }
    }
}
