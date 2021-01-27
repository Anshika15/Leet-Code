class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int res[] = new int[queries.length];
        
        int pre[] = new int[arr.length];
        pre[0] = arr[0];
		for(int i = 1; i < arr.length; i++)
		{
			pre[i] = arr[i] ^ pre[i-1];
		}
		
        
        for(int i = 0; i < queries.length; i++)
        {
           int l = queries[i][0];
           int r = queries[i][1];
           if(l == 0)
			    res[i] =  pre[r];
		   else
               res[i] = pre[r]^pre[l-1];
        }
		return res;
        
    }
}
