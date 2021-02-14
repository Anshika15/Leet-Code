class Solution {
    class Point{
        int x;
        int y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    class Node{
        Point pt;
        int dist;
        Node(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    }
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(grid[0][0] != 0 || grid[rows-1][cols-1] != 0)
            return -1;
        
        Point src = new Point(0,0);
        Point dest = new Point(rows-1, cols-1);
        int dist = bfs(grid, src, dest);
        return dist;
        
    }
    
    
    int bfs(int[][] grid, Point src, Point dest)
    {
        int rowNum[] = {1, 1, 0, -1, -1, -1, 0, 1};
        int colNum[] = {0, 1, 1, 1, 0, -1, -1, -1};
        
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println(rows + " " + cols);
        
        boolean vis[][] = new boolean[rows][cols];
        
        vis[src.x][src.y] = true;
        
        Node qnode = new Node(src, 1);
        Queue<Node> q = new LinkedList<>();
        
        q.add(qnode);
        
        while(!q.isEmpty())
        {
            Node curr = q.peek();
            Point pt = curr.pt;
            System.out.println(pt.x + " " + pt.y);
            
            if(pt.x == dest.x && pt.y == dest.y)
                return curr.dist;
            
            q.remove();
            
            for(int i = 0; i < 8; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];
                System.out.println(row + " " + col);
                
                if(row >= 0 && row < rows && col >= 0 && col < cols && !vis[row][col] && grid[row][col] == 0)
                {
                    vis[row][col] = true;
                    Node adjnode = new Node(new Point(row, col), curr.dist + 1);
                    q.add(adjnode);
                }
            }
        }
        return -1;
    }
}
