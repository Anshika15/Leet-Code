class Solution {
    
    int dx[] = {-1, 0, 1, 0};
    int dy[] = {0, -1, 0, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image[sr][sc] == newColor) return image;
        
        int prevColor = image[sr][sc];
        colorHelper(image, sr, sc, newColor, prevColor);
        return image;
        
    }
    
    public void colorHelper(int[][] image, int sr, int sc, int nc, int pc)
    {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != pc)
            return;
        
        image[sr][sc] = nc;
      
        for(int i = 0; i < 4; i++)
        {
            colorHelper(image, sr + dx[i], sc + dy[i], nc, pc);
        }
    }
}
