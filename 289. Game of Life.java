class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}, {-1,1}, {1, -1},{-1,-1}, {1,1}};
    public void gameOfLife(int[][] board) {
        
       int[][] res = new int[board.length][board[0].length];
       for(int i = 0; i < board.length; i++)
       {
           for(int j = 0; j < board[i].length; j++)
           {
               res[i][j] = board[i][j];
               solve(board, i, j, res);
           }
       }
        
       for(int i = 0; i < board.length; i++)
       {
           for(int j = 0; j < board[i].length; j++)
           {
               board[i][j] = res[i][j];
           }
       }
        
    }
    
    void solve(int[][] board, int i, int j, int[][] res)
    {
        int live = 0;
        for(int idx = 0; idx < 8; idx++)
        {
            int rowdash = dirs[idx][0] + i;
            int coldash = dirs[idx][1] + j;
            if(isValidDirections(board.length, board[0].length, rowdash, coldash) && board[rowdash][coldash] == 1)
                live++;
        }
        
        if(board[i][j] == 1 && (live < 2 || live > 3))
            res[i][j] = 0;
        else if(board[i][j] == 0 && live == 3)
                res[i][j] = 1;
        else if(board[i][j] == 1 && (live == 2 || live == 3))
            res[i][j] = 1;
        
    }
    
    boolean isValidDirections(int rows, int cols, int i, int j)
    {
        if(i >= 0 && i < rows && j >= 0 && j < cols)
            return true;
        return false;
    }
}
