class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        for(int i = 0; i < mat.length; i++)
            sort(mat, i, 0);
        for(int j = 0; j < mat[0].length; j++)
            sort(mat, 0, j);
        return mat;
    } 
    public void sort(int[][] mat, int i, int j)
    {
        int temp[] = new int[mat[0].length];
        int si = i, sj = j;
        int t = 0;
        while(i < mat.length && j < mat[0].length)
        {
            temp[t] = mat[i][j];
            t++;
            i++;
            j++;
        }
        Arrays.sort(temp);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int w = 0; w < temp.length; w++)
        {
            if(temp[w] != 0)
                list.add(temp[w]);
        }
        t = 0;
        while(si < mat.length && sj < mat[0].length && t < list.size())
        {
            mat[si][sj] = list.get(t);
            t++;
            si++;
            sj++;
        }
       
    }
}
