class Solution {
    public int slidingPuzzle(int[][] board) {
        String solvedState = "123450";
        
        int[][] dirs = {
            {1, 3}, /* cell nums*/
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {2, 4}
        };
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                sb.append(board[i][j]); /* current state of board */
            }
        }
        
        int level = -1;
        LinkedList<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.add(sb.toString());
        vis.add(sb.toString());
        
        while(q.size() > 0)
        {
            int size = q.size();
            level++;
            while(size-- > 0)
            {
                String rem = q.removeFirst();
                if(rem.equals(solvedState))
                    return level;
                
                int index = -1;
                for(int i = 0; i < rem.length(); i++)
                {
                    if(rem.charAt(i) == '0')
                    {
                        index = i;
                        break;
                    }
                }
                
                int swap[] = dirs[index];
                for(int i = 0; i < swap.length; i++)
                {
                    String str = swapString(rem, index, swap[i]);
                    if(vis.contains(str))
                        continue;
                    q.add(str);
                    vis.add(str);
                }
                
            }
        }
        return -1;
    }
    
    String swapString(String st, int index1, int index2)
    {
        StringBuilder sb = new StringBuilder(st);
        sb.setCharAt(index1, st.charAt(index2));
        sb.setCharAt(index2, st.charAt(index1));
        return sb.toString();
    }
}
