class Solution {
    public int[] productExceptSelf(int[] arr) {
        
        int rpdt[] = new int[arr.length];
        rpdt[arr.length-1] = 1;
        int res[] = new int[arr.length];
        for(int i = arr.length-2; i >= 0; i--)
        {
            rpdt[i] = rpdt[i+1]*arr[i+1];
        }

        int lpdt = 1;
        for(int i = 0; i < arr.length; i++)
        {
            res[i] = lpdt*rpdt[i];
            lpdt = lpdt*arr[i];
        }
        return res;
        
    }
}
