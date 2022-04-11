class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        while(k-- > 0)
        {
            int prev = grid[grid.length-1][grid[0].length-1];
            for(int rowIdx = 0; rowIdx < grid.length; rowIdx++)
            {
                for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++)
                {
                    int temp = grid[rowIdx][colIdx];
                    grid[rowIdx][colIdx] = prev;
                    prev = temp;
                }
            }
        }
        
        return createList(grid);
        
    }

    
    List<List<Integer>> createList(int[][] grid)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int rowIdx = 0; rowIdx < grid.length; rowIdx++)
        {
            ArrayList<Integer> smallRes = new ArrayList<>();
            for(int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++)
            {
                smallRes.add(grid[rowIdx][colIdx]);
            }
            result.add(smallRes);
        }
        return result;
    }
}
