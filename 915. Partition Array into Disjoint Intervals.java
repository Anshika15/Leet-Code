class Solution {
    public int partitionDisjoint(int[] arr) {
        
        int lmax = arr[0];
        int greater = arr[0];
        int ans = 0;

        for(int i = 1; i <arr.length; i++)
        {
            if(arr[i] > greater)
                greater = arr[i];
            else if(arr[i] < lmax)
            {
                lmax = greater;
                ans = i;
            }
        }

        return ans+1;
        
    }
}
