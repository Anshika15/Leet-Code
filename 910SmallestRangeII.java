class Solution {
    public int smallestRangeII(int[] A, int k) {
        
      /*  if(A.length == 1 || A.length == 0)
            return 0;*/
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0];
        for(int i = 0; i < A.length - 1; i++)
        {
            int mx = Math.max(A[i] + k, A[A.length-1] - k);
            int mn = Math.min(A[0] + k, A[i+1] - k);
            res = Math.min(res, mx - mn);   
        }
        return res;
        
    }
}
