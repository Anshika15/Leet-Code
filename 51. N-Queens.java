class Solution {
    List<List<String>> res = new ArrayList<>();
    int N;
    
    public List<List<String>> solveNQueens(int n) {
        N = n;
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
       
        boolean var = nQueen(0, board);
        
        return res;
        
    }
    
    boolean nQueen(int col, char board[][])
    {
        if(col == N)
        {
            addList(board);
            return true;
        }
        
        boolean b = false;
        for(int i = 0; i < N; i++)
        {
            if(isSafe(i, col, board))
            {
                board[i][col] = 'Q';
                b = nQueen(col+1, board) || b;
                board[i][col] = '.';
            }
        }
        return b;
    }
    
    boolean isSafe(int row, int  col,char[][] board)
    {
        for(int i = 0; i < col; i++)
            if(board[row][i] == 'Q')
                return false;
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--)
            if(board[i][j] == 'Q')
                return false;
        for(int i = row, j = col; i < N && j >= 0; i++,j--)
            if(board[i][j] == 'Q')
                return false;
        return true;
    }
    
    void addList(char board[][])
    {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < N; i++)
        {
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < N; j++)
            {
                sb.append(board[i][j]);
            }
           // System.out.println(sb.toString());
            list.add(sb.toString());
          // Collections.addAll(list, board[i]); 
        }
        res.add(list);
    }
}
