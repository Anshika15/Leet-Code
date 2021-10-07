class Solution {
    boolean res;
    public boolean exist(char[][] board, String word) {
        
        boolean vis[][] = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(!vis[i][j])
                {
                    dfs(i, j, board, vis, word, 0);
                    if(res) return true;
                }
            }
        }
        return false;
        
    }
    
    void dfs(int i, int j, char[][] board, boolean vis[][], String word, int idx)
    {
        if(word.length() == idx){
            res = true;
            return;
        }
        if(idx > word.length() || i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] || word.charAt(idx) != board[i][j])
            return;
        vis[i][j] = true;
        dfs(i+1, j, board, vis, word, idx+1);
        dfs(i-1, j, board, vis, word, idx+1);
        dfs(i, j+1, board, vis, word, idx+1);
        dfs(i, j-1, board, vis, word, idx+1);
        vis[i][j] = false;
    }
}
