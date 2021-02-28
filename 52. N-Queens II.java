class Solution {
    int count = 0;
    int N;
    public int totalNQueens(int n) {
        
        N = n;
        int board[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], 0);
        boolean b = nQueen(0, board);
        return count;  
    }
    
    boolean nQueen(int col, int[][] board)
    {
        if(col == N)
        {
            count++;
            return true;
        }
        boolean b = false;
        for(int i = 0; i < N; i++)
        {
            if(isSafe(i, col, board))
            {
                board[i][col] = 1;
                b = nQueen(col+1, board) || b;
                board[i][col] = 0;
            }
        }
        return b;
    }
    
    boolean isSafe(int row, int col, int[][] board)
    {
        for(int i = 0; i < col; i++)
            if(board[row][i] == 1)
                return false;
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--)
            if(board[i][j] == 1)
                return false;
        for(int i = row, j = col; i < N && j >= 0; i++,j--)
            if(board[i][j] == 1)
                return false;
        return true;
    }
}
