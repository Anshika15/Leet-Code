class Solution {
    public boolean checkValid(int[][] matrix) {
        
        HashSet<Integer> set = new HashSet<>();
        int n = matrix.length;
        for(int i = 0; i < n; i++)
        {
            set = new HashSet<>();
            for(int j = 0; j < n; j++)
            {
                set.add(matrix[i][j]);
            }
            if(set.size() != n)
                return false;
        }
        
        for(int i = 0; i < n; i++)
        {
            set = new HashSet<>();
            for(int j = 0; j < n; j++)
            {
                set.add(matrix[j][i]);
            }
            if(set.size() != n)
                return false;
        }
        return true;
    }
}
