class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        int t[] = new int[A.length];
        Arrays.fill(t, 0);
        int sum = 0;
        for(int i = 2; i < A.length; i++)
        {
            if((A[i] - A[i-1]) == (A[i-1] - A[i-2]))
            {
                t[i] = t[i-1] + 1;
            }
            else
                t[i] = 0;
            sum += t[i];
        }
        return sum;
        
    }
}
