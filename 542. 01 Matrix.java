class Solution {
    
    class Pair{
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] dirs = {{1,0}, {0,1}, {-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        
        LinkedList<Pair> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[i].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.addLast(new Pair(i,j));
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(q.size() > 0)
        {
            Pair rem = q.removeFirst();
            
            for(int i = 0; i < dirs.length; i++)
            {
                int rowdash = rem.x + dirs[i][0];
                int coldash = rem.y + dirs[i][1];
                
                if(coldash >= 0 && rowdash >= 0 && coldash < mat[0].length && rowdash < mat.length && mat[rowdash][coldash] < 0)
                {
                    q.addLast(new Pair(rowdash, coldash));
                    mat[rowdash][coldash] = mat[rem.x][rem.y] + 1;
                }
            }
        }
        
        return mat;
        
        
    }
}