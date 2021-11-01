class Solution {
    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(i == 0 || i == board.length-1 || j == 0 || j == board[i].length-1)
                    dfs(board, i, j);
            }
        }
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        
    }
    
    public void dfs(char board[][], int i, int j)
    {
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O')
            return;
        board[i][j] = 'A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
        
    }
}
