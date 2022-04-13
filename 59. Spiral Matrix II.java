class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int minr = 0;
        int minc = 0;
        int maxr = n-1;
        int maxc = n-1;
        int total = n*n;
        int val = 1;

        while(val <= total)
        {
            // top wall
            for(int i = minr, j = minc; j <= maxc && val <= total; j++)
            {
                matrix[i][j] = val;
                val++;
            }
            minr++;
            
             // right wall
            for(int i = minr, j = maxc; i <= maxr && val <= total ; i++)
            {
                matrix[i][j] = val;
                val++;
            }
            maxc--;
            
            // bottom wall
            for(int i = maxr, j = maxc; j >= minc && val <= total; j--)
            {
                matrix[i][j] = val;
                val++;
            }
            maxr--;
            
             // left wall
            for(int i = maxr, j = minc; i >= minr && val <= total; i--)
            {
                matrix[i][j] = val;
                val++;
            }
            minc++;
        }
        
        return matrix;
        
    }
}
