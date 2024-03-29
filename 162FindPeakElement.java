class Solution {
    public int findPeakElement(int[] arr) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        if(size == 1)
            return 0;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(mid > 0 && mid < size-1)
            {
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                    return mid;
                else if(arr[mid - 1] > arr[mid])
                    end = mid - 1;
                else start = mid + 1;
            }
            else if(mid == 0)
            {
                if(arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            }
            else if(mid == size - 1)
            {
                if(arr[size-1] > arr[size-2])
                    return size - 1;
                else
                    return size - 2;
            }
        }
        return -1;
        
    }
}
