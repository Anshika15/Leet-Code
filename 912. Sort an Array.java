class Solution {
    public int[] sortArray(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1)
            return nums;
        
        return mergeSort(nums, 0, nums.length-1);
        
    }
    
    int[] mergeSort(int[] nums, int start, int end)
    {
        if(start == end)
        {
            int res[] = new int[1];
            res[0] = nums[start];
            return res;
        
        }
        int mid = start + (end-start)/2;
        
        int a1[] = mergeSort(nums, start, mid);
        int a2[] = mergeSort(nums, mid+1, end);
        
        return merge(a1,a2);
    }
    
    int[] merge(int[] a1, int[] a2)
    {
        int[] res = new int[a1.length + a2.length];
        int k = 0;
        int i = 0; int j = 0;
        while(i < a1.length && j < a2.length)
        {
            if(a1[i] < a2[j])
            {
                res[k] = a1[i];
                i++;
            }
            else
            {
                res[k] = a2[j];
                j++;
            }
            k++;
        }
        
        while(i < a1.length)
        {
            res[k] = a1[i];
            i++;
            k++;
        }
        while(j < a2.length)
        {
            res[k] = a2[j];
            j++;
            k++;
        }
        return res;
    }
}
