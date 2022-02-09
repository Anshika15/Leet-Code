class Solution {
    public int longestOnes(int[] arr, int k) {
        
        int res = 0;

        int j = -1;
        int c = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0)
                c++;

            while(c > k && j < arr.length)
            {
                j++;
                if(arr[j] == 0)
                    c--;
            }
            res = Math.max(res, i -j);
        }
        return res;
        
    }
}
