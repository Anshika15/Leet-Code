class Solution {
    public int pivotIndex(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        
        int lsum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int rsum = sum - lsum - arr[i];
            if(rsum == lsum)
                return i;
            lsum += arr[i];
        }
        return -1;
        
    }
}
