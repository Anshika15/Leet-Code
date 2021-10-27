class Solution {
    public void sortColors(int[] arr) {
    /* i to k => unknown */
    /* j to i-1 => ones */
    /* 0 to j-1 => zeroes */
    /* k+1 to end => twos */
    
    int i = 0; int j = 0; int k = arr.length-1;
    while(i <= k)
    {
        if(arr[i] == 1)
        {
            i++;
        }
        else if(arr[i] == 0)
        {
            swap(arr, i, j);
            i++;
            j++;
        }
        else
        {
            swap(arr, i, k);
            k--;
        }
    }
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
